package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.constant.SedisQuestion;
import com.zhihuishu.athomework.dto.*;
import com.zhihuishu.athomework.mapper.master.*;
import com.zhihuishu.athomework.redis.RedisKeyUtil;
import com.zhihuishu.athomework.service.*;
import com.zhihuishu.athomework.utils.DateConvert;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class QuestionServiceImpl extends BaseService implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private KenService kenService;

    @Resource
    private QuestionCourseService questionCourseService;

    @Resource
    private QuestionFileService questionFileService;

    @Resource
    private QuestionKenService questionKenService;

    @Resource
    private QuestionOptionService questionOptionService;

    @Override
    public QuestionDto findQuesBaseInfo(Long questionId){
        QuestionDto questionDto = null;

        try {
            String quesRedisKey = RedisKey.generateQuestionKey(questionId);
            Map<String, String> questionMap = jedisTemplate.hgetAll(quesRedisKey);//读缓存

            if(CollectionUtils.isEmpty(questionMap)){
                questionDto = questionMapper.findQuestionInfo(questionId); //查库
                if(questionDto != null) {
                    putQuestionInfo2Redis(questionDto, quesRedisKey); //放入缓存
                }
            } else {
                questionDto = convertMap2Question(questionMap); //取缓存
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questionDto;
    }

    @Override
    public QuestionDto findQuestionInfo(Long questionId) {
        Assert.notNull(questionId, "题目id不能为空");

        QuestionDto questionDto = findQuesBaseInfo(questionId); //查询题目基本信息

        List<QuestionFileDto> quesFileDtoList = questionFileService.findQuesFileByQuesId(questionId); //附件信息
        questionDto.setQuestionFileDtoList(quesFileDtoList);

        List<QuestionOptionDto> quesOptionDtoList = questionOptionService.findOptionByQuesId(questionId); //选项信息
        questionDto.setQuestionOptionDtoList(quesOptionDtoList);

        return questionDto;
    }

    @Override
    public QuestionDto findQuesDetailInfo(Long questionId) {
        QuestionDto questionDto = null;
        try {
            questionDto = questionMapper.findQuestionInfo(questionId);

            List<QuestionOptionDto> quesOptionDtoList = questionOptionService.findOptionByQuesId(questionId);
            questionDto.setQuestionOptionDtoList(quesOptionDtoList);

            List<QuestionCourseDto> quesourseDtoList = questionCourseService.findQuesCourseByQuesId(questionId);
            questionDto.setQuestionCourseDtoList(quesourseDtoList);

            List<QuestionKenDto> quesKenDtoList = questionKenService.findQuesKenByQuesId(questionId);
            for (QuestionKenDto qkDto : quesKenDtoList) {
                KenDto kenDto = kenService.findKenById(qkDto.getKenId());
                qkDto.setKenDto(kenDto);
            }
            questionDto.setQuestionKenDtoList(quesKenDtoList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return questionDto;
    }

    @Override
    @Transactional
    public Boolean saveChoiceQuesManually(QuestionDto questionDto, List<QuestionFileDto> quesFileDtoList, List<KenDto> kenDtoList,
                                          List<QuestionOptionDto> quesOptionDtoList, List<QuestionCourseDto> quesCourseDtoList) {
        try {
            Integer result = questionMapper.saveQuestionInfo(questionDto);
            if(result == 1) {
                Long questionId = questionDto.getId();

                //过滤重复的课程关联
                Set<QuestionCourseDto> quesCourseSet = new HashSet<>();
                for (QuestionCourseDto qcDto : quesCourseDtoList) {
                    qcDto.setQuestionId(questionId);
                    quesCourseSet.add(qcDto);
                }
                questionCourseService.saveQuesCourseBatch(quesCourseSet);

                for (QuestionFileDto qfDto : quesFileDtoList) {
                    qfDto.setQuestionId(questionId);
                }

                questionFileService.saveQuesFileBatch(quesFileDtoList);

                for (QuestionOptionDto qoDto : quesOptionDtoList) {
                    qoDto.setQuestionId(questionId);
                }
                questionOptionService.saveOptionBatch(quesOptionDtoList);

                Long[] kenIds = saveKenAndGetIds(kenDtoList); //处理知识点
                questionKenService.saveQuesKenBatch(kenIds, questionId);

                return true;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean saveJudgeQuesManually(QuestionDto questionDto, List<QuestionFileDto> quesFileDtoList, List<KenDto> kenDtoList,
                                         List<QuestionCourseDto> quesCourseDtoList) {
        try {
            Integer result = questionMapper.saveQuestionInfo(questionDto);
            if(result == 1) {
                Long questionId = questionDto.getId();

                Set<QuestionCourseDto> questionCourseSet = new HashSet<>();
                for (QuestionCourseDto qcDto : quesCourseDtoList) {
                    qcDto.setQuestionId(questionId);
                    questionCourseSet.add(qcDto);
                }
                questionCourseService.saveQuesCourseBatch(questionCourseSet);

                questionFileService.saveQuesFileBatch(quesFileDtoList);

                Long[] kenIds = saveKenAndGetIds(kenDtoList); //处理知识点
                questionKenService.saveQuesKenBatch(kenIds, questionId);

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean saveFillingQuesManually(QuestionDto questionDto, List<QuestionFileDto> quesFileDtoList, List<KenDto> kenDtoList,
                                           List<QuestionOptionDto> quesOptionDtoList, List<QuestionCourseDto> quesCourseDtoList) {
        try {
            Integer result = questionMapper.saveQuestionInfo(questionDto);
            if(result == 1) {
                Long questionId = questionDto.getId();

                Set<QuestionCourseDto> questionCourseSet = new HashSet<>();
                for (QuestionCourseDto qcDto : quesCourseDtoList) {
                    qcDto.setQuestionId(questionId);
                    questionCourseSet.add(qcDto);
                }
                questionCourseService.saveQuesCourseBatch(questionCourseSet);

                questionFileService.saveQuesFileBatch(quesFileDtoList);

                for (QuestionOptionDto qoDto : quesOptionDtoList) {
                    qoDto.setQuestionId(questionId);
                }
                questionOptionService.saveOptionBatch(quesOptionDtoList);

                Long[] kenIds = saveKenAndGetIds(kenDtoList); //处理知识点
                questionKenService.saveQuesKenBatch(kenIds, questionId);

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean saveAnswerQuesManually(QuestionDto questionDto, List<QuestionFileDto> quesFileDtoList, List<KenDto> kenDtoList,
                                          List<QuestionCourseDto> quesCourseDtoList) {
        try {
            //保存题目的基本信息，并得到新生成的主键
            Integer result = questionMapper.saveQuestionInfo(questionDto);
            Long questionId = questionDto.getId();

            if(result == 1) {
                //去除重复的关联课程章节
                Set<QuestionCourseDto> questionCourseSet = new HashSet<>();
                for (QuestionCourseDto qcDto : quesCourseDtoList) {
                    qcDto.setQuestionId(questionId); //设置题目id
                    questionCourseSet.add(qcDto);
                }
                questionCourseService.saveQuesCourseBatch(questionCourseSet); //入库

                questionFileService.saveQuesFileBatch(quesFileDtoList);

                Long[] kenIds = saveKenAndGetIds(kenDtoList); //去除重复知识点、入库
                questionKenService.saveQuesKenBatch(kenIds, questionId);

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean saveComboQuesManually(QuestionDto mainQuestionDto, List<QuestionDto> subQuestionDtoList,
                                         List<QuestionFileDto> quesFileDtoList, List<KenDto> kenDtoList, List<QuestionCourseDto> quesCourseDtoList) {
        try {
            Integer result = questionMapper.saveQuestionInfo(mainQuestionDto);
            if(result == 1) {
                Long questionId = mainQuestionDto.getId();

                Set<QuestionCourseDto> questionCourseSet = new HashSet<>();
                for (QuestionCourseDto qcDto : quesCourseDtoList) {
                    qcDto.setQuestionId(questionId);
                    questionCourseSet.add(qcDto);
                }
                questionCourseService.saveQuesCourseBatch(questionCourseSet);

                questionFileService.saveQuesFileBatch(quesFileDtoList);

                Long[] kenIds = saveKenAndGetIds(kenDtoList); //处理知识点
                questionKenService.saveQuesKenBatch(kenIds, questionId);

                //保存小题
                for (QuestionDto questionDto : subQuestionDtoList) {
                    questionMapper.saveQuestionInfo(questionDto);
                }

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    @Transactional
    public Boolean updateChoiceQues(QuestionDto questionDto, Long[] delFileIds, List<QuestionFileDto> addQuesFileDtoList, Long[] delOptionIds,
                                    List<QuestionOptionDto> addQuesOptionDtoList, List<QuestionCourseDto> quesCourseDtoList,
                                    List<KenDto> kenDtoList) {
        try {
            Long questionId = questionDto.getId();
            questionMapper.updateQuestionInfo(questionDto); //更新题目基本信息

            //删除、添加文件关联
            questionFileService.delQuesFileByIdBatch(delFileIds);
            for (QuestionFileDto qfDto : addQuesFileDtoList) {
                qfDto.setQuestionId(questionId);
            }
            questionFileService.saveQuesFileBatch(addQuesFileDtoList);

            //删除、添加选项关联
            questionOptionService.delOptionBatch(delOptionIds);
            for (QuestionOptionDto qoDto : addQuesOptionDtoList) {
                qoDto.setQuestionId(questionId);
            }
            questionOptionService.saveOptionBatch(addQuesOptionDtoList);

            //删除所有旧的课程关联，并添加新的课程关联
            questionCourseService.delQuesCourseByQuesId(questionId);
            Set<QuestionCourseDto> quesCourseSet = new HashSet<>();
            for (QuestionCourseDto qcDto : quesCourseDtoList) {
                qcDto.setQuestionId(questionId);
                quesCourseSet.add(qcDto);
            }
            questionCourseService.saveQuesCourseBatch(quesCourseSet);

            questionKenService.delQuesKenByQuesId(questionId); //删除题目下的所有关联知识点
            Long[] kenIds = saveKenAndGetIds(kenDtoList); //处理知识点

            questionKenService.saveQuesKenBatch(kenIds, questionId); //保存知识点关联

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteQuesLogically(Long questionId) {
        try {
            questionMapper.delQuesLogically(questionId);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * @Description 对教师编辑的知识点进行过滤，判断是否已存在，不存在的则插入ken库
     * @author lvxiangjun
     * @param kenDtoList 知识点集合
     * @date 2018-7-18 18:39:39
     * @return 所有知识点的id
     */
    private Long[] saveKenAndGetIds(List<KenDto> kenDtoList){
        List<Long> addKenIds = new ArrayList<>();

        for (KenDto kenDto : kenDtoList) {
            Long id = kenService.getIdByCourseIdAndTitle(kenDto.getCourseId(),kenDto.getTitle()); //查询编辑的知识点是否已存在
            if(id != null){
                //如果存在，记录id
                addKenIds.add(id);
            } else {
                //如果不存在，保存新的知识点到ken库, 并记录生成的id
                kenService.saveKen(kenDto);
                addKenIds.add(kenDto.getId());
            }
        }

        return addKenIds.toArray(new Long[addKenIds.size()]);
    }

    /**
     * @Description 将题目的基本信息放入缓存
     * @author lvxiangjun
     * @param questionDto 题目基本信息dto
     * @param redisKey redis键
     * @date 2018-7-24 10:00:28
     */
    private void putQuestionInfo2Redis(QuestionDto questionDto, String redisKey){
        Map<String, String> map = new HashMap<>();

        Long id = questionDto.getId();
        Integer questionTypeId = questionDto.getQuestionTypeId();
        Integer diff = questionDto.getDiff();
        String content = questionDto.getContent();
        String result = questionDto.getResult();
        Integer from = questionDto.getFrom();
        Integer hit = questionDto.getHit();
        Date createTime = questionDto.getCreateTime();
        Boolean display = questionDto.getDisplay();
        Long userId = questionDto.getUserId();
        Long parentId = questionDto.getParentId();
        String analysis = questionDto.getAnalysis();
        Integer schoolId = questionDto.getSchoolId();
        Date updateTime = questionDto.getUpdateTime();
        Long lastUpdateUserId = questionDto.getLastUpdateUserId();
        Boolean deleted = questionDto.getDeleted();

        if(id != null){
            map.put(SedisQuestion.QUESTION_ID, id.toString());
        }
        if(questionTypeId != null){
            map.put(SedisQuestion.QUESTION_QUESTIONTYPEID, questionTypeId.toString());
        }
        if(diff != null){
            map.put(SedisQuestion.QUESTION_DIFF, diff.toString());
        }
        if(StringUtils.isNotEmpty(content)){
            map.put(SedisQuestion.QUESTION_CONTENT, content);
        }
        if(StringUtils.isNotEmpty(result)){
            map.put(SedisQuestion.QUESTION_RESULT, result);
        }
        if(from != null){
            map.put(SedisQuestion.QUESTION_FROM, from.toString());
        }
        if(hit != null){
            map.put(SedisQuestion.QUESTION_HIT, hit.toString());
        }
        if(createTime != null){
            map.put(SedisQuestion.QUESTION_CREATETIME, DateConvert.DateToStr(createTime));
        }
        if(display != null){
            map.put(SedisQuestion.QUESTION_DISPLAY, display.toString());
        }
        if(userId != null){
            map.put(SedisQuestion.QUESTION_USERID, userId.toString());
        }
        if(parentId != null){
            map.put(SedisQuestion.QUESTION_PARENTID, parentId.toString());
        }
        if(StringUtils.isNotEmpty(analysis)){
            map.put(SedisQuestion.QUESTION_ANALYSIS, analysis);
        }
        if(schoolId != null){
            map.put(SedisQuestion.QUESTION_SCHOOLID, schoolId.toString());
        }
        if(updateTime != null){
            map.put(SedisQuestion.QUESTION_UPDATETIME, DateConvert.DateToStr(updateTime));
        }
        if(lastUpdateUserId != null){
            map.put(SedisQuestion.QUESTION_LASTUPDATEUSERID, lastUpdateUserId.toString());
        }
        if(deleted != null){
            map.put(SedisQuestion.QUESTION_DELETED, deleted.toString());
        }

        jedisTemplate.hmset(redisKey, map);
        jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
    }

    /**
     * @Description 将map转换为QuestionDto
     * @author lvxiangjun
     * @param map redis查询出的map
     * @date 2018-7-24 10:02:16
     */
    private QuestionDto convertMap2Question(Map<String, String> map){
        QuestionDto questionDto = new QuestionDto();

        String id = map.get(SedisQuestion.QUESTION_ID);
        String questionTypeId = map.get(SedisQuestion.QUESTION_QUESTIONTYPEID);
        String diff = map.get(SedisQuestion.QUESTION_DIFF);
        String content = map.get(SedisQuestion.QUESTION_CONTENT);
        String result = map.get(SedisQuestion.QUESTION_RESULT);
        String from = map.get(SedisQuestion.QUESTION_FROM);
        String hit = map.get(SedisQuestion.QUESTION_HIT);
        String createTime = map.get(SedisQuestion.QUESTION_CREATETIME);
        String display = map.get(SedisQuestion.QUESTION_DISPLAY);
        String userId = map.get(SedisQuestion.QUESTION_USERID);
        String parentId = map.get(SedisQuestion.QUESTION_PARENTID);
        String analysis = map.get(SedisQuestion.QUESTION_ANALYSIS);
        String schoolId = map.get(SedisQuestion.QUESTION_SCHOOLID);
        String updateTime = map.get(SedisQuestion.QUESTION_UPDATETIME);
        String lastUpdateUserId = map.get(SedisQuestion.QUESTION_LASTUPDATEUSERID);
        String deleted = map.get(SedisQuestion.QUESTION_DELETED);

        if(StringUtils.isNotEmpty(id)){
            questionDto.setId(Long.parseLong(id));
        }
        if(StringUtils.isNotEmpty(questionTypeId)){
            questionDto.setQuestionTypeId(Integer.parseInt(questionTypeId));
        }
        if(StringUtils.isNotEmpty(diff)){
            questionDto.setDiff(Integer.parseInt(diff));
        }
        if(StringUtils.isNotEmpty(content)){
            questionDto.setContent(content);
        }
        if(StringUtils.isNotEmpty(result)){
            questionDto.setResult(result);
        }
        if(StringUtils.isNotEmpty(from)){
            questionDto.setFrom(Integer.parseInt(from));
        }
        if(StringUtils.isNotEmpty(hit)){
            questionDto.setHit(Integer.parseInt(hit));
        }
        if(StringUtils.isNotEmpty(createTime)){
            questionDto.setCreateTime(DateConvert.StrToDate(createTime));
        }
        if(StringUtils.isNotEmpty(display)){
            questionDto.setDisplay(Boolean.parseBoolean(display));
        }
        if(StringUtils.isNotEmpty(userId)){
            questionDto.setUserId(Long.parseLong(userId));
        }
        if(StringUtils.isNotEmpty(parentId)){
            questionDto.setParentId(Long.parseLong(parentId));
        }
        if(StringUtils.isNotEmpty(analysis)){
            questionDto.setAnalysis(analysis);
        }
        if(StringUtils.isNotEmpty(schoolId)){
            questionDto.setSchoolId(Integer.parseInt(schoolId));
        }
        if(StringUtils.isNotEmpty(updateTime)){
            questionDto.setUpdateTime(DateConvert.StrToDate(updateTime));
        }
        if(StringUtils.isNotEmpty(lastUpdateUserId)){
            questionDto.setLastUpdateUserId(Long.parseLong(lastUpdateUserId));
        }
        if(StringUtils.isNotEmpty(deleted)){
            questionDto.setDeleted(Boolean.parseBoolean(deleted));
        }

        return questionDto;
    }
}
