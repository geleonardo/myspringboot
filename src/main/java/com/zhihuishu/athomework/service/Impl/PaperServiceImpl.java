package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.constant.SedisPaper;
import com.zhihuishu.athomework.dto.PaperDto;
import com.zhihuishu.athomework.dto.PaperGroupDto;
import com.zhihuishu.athomework.dto.QuestionDto;
import com.zhihuishu.athomework.mapper.master.PaperMapper;
import com.zhihuishu.athomework.model.Paper;
import com.zhihuishu.athomework.model.PaperGroup;
import com.zhihuishu.athomework.redis.RedisKeyUtil;
import com.zhihuishu.athomework.service.PaperGroupService;
import com.zhihuishu.athomework.service.PaperQuestionService;
import com.zhihuishu.athomework.service.PaperService;
import com.zhihuishu.athomework.service.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaperServiceImpl extends BaseService implements PaperService {

    @Resource
    private PaperMapper paperMapper;

    @Resource
    private PaperGroupService paperGroupService;

    @Resource
    private PaperQuestionService paperQuestionService;

    @Resource
    private QuestionService questionService;

    @Override
    public  PaperDto findPaperInfo(Long paperId){
        PaperDto paperDto=null;
        try {
            paperDto = this.getPaperInfo(paperId);
            List<String> groupIds = paperGroupService.findPaperGroupIDS(paperId);
            if (groupIds != null && groupIds.size() > 0) {
                List<PaperGroupDto> paperGroupDtos = new ArrayList<PaperGroupDto>();
                List<QuestionDto> questionDtos= new ArrayList<QuestionDto>();
                PaperGroupDto paperGroupDto =null;
                QuestionDto questionDto=null;
                for (String groupId : groupIds) {
                    paperGroupDto = paperGroupService.findPaperGroupInfo(Long.valueOf(groupId));
                    List<String> questionIds=paperQuestionService.findPaperQuestionIDS(Long.valueOf(groupId));
                    for(String questionId:questionIds){
                        questionDto=questionService.findQuestionInfo(Long.valueOf(questionId));
                        questionDtos.add(questionDto);
                    }
                    paperGroupDto.setQuestionDtos(questionDtos);
                    paperGroupDtos.add(paperGroupDto);
                }
                paperDto.setGroupDtos(paperGroupDtos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperDto;
    }

    public PaperDto getPaperInfo(Long paperId) {
        PaperDto paperDto = null;
        try {
            String redisKey = RedisKey.generatePaperKey(paperId);
            Map<String, String> stringMap = jedisTemplate.hgetAll(redisKey);
            if (stringMap != null && !stringMap.isEmpty()) {
                paperDto = getRedis_PaperModel(stringMap);
            } else {
                paperDto = paperMapper.getPaperInfo(paperId);
                setRedis_PaperModel(paperDto, redisKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperDto;
    }

    @Override
    public Integer updatePaperDemo(PaperDto paperDto) {
        Integer result = -1;
        try {
            Assert.notNull(paperDto.getId(), "id不能为空");
            result = paperMapper.updatePaperDemo(paperDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer insertPaperDemo(PaperDto paperDto) {
        Integer result = -1;
        try {
            result = paperMapper.insertPaperDemo(paperDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private PaperDto getRedis_PaperModel(Map<String, String> stringMap) {
        PaperDto model = new PaperDto();
        String id = stringMap.get(SedisPaper.PAPER_ID);
        String title = stringMap.get(SedisPaper.PAPER_TITLE);
        String userId = stringMap.get(SedisPaper.PAPER_USERID);
        String courseId = stringMap.get(SedisPaper.PAPER_COURSEID);
        String createTime = stringMap.get(SedisPaper.PAPER_CREATETIME);
        String paperType = stringMap.get(SedisPaper.PAPER_PAPERTYPE);
        String schoolId = stringMap.get(SedisPaper.PAPER_SCHOOLID);

        if (StringUtils.isNotEmpty(id)) {
            model.setId(Long.valueOf(id));
        }
        if (StringUtils.isNotEmpty(title)) {
            model.setTitle(title);
        }
        if (StringUtils.isNotEmpty(userId)) {
            model.setUserId(Long.valueOf(userId));
        }
        if (StringUtils.isNotEmpty(courseId)) {
            model.setCourseId(Long.valueOf(courseId));
        }
        if (StringUtils.isNotEmpty(createTime)) {
            model.setCreateTime(Date.valueOf(createTime));
        }
        if (StringUtils.isNotEmpty(paperType)) {
            model.setPaperType(Integer.valueOf(paperType));
        }
        if (StringUtils.isNotEmpty(schoolId)) {
            model.setSchoolId(Integer.valueOf(schoolId));
        }
        return model;
    }

    private void setRedis_PaperModel(PaperDto model, String redisKey) {
        if (model != null) {
            Map<String, String> map = new HashMap<String, String>();
            Long id = model.getId();
            if (id != null) {
                map.put(SedisPaper.PAPER_ID, id.toString());
            }
            String title = model.getTitle();
            if (title != null) {
                map.put(SedisPaper.PAPER_TITLE, title);
            }
            Long userId = model.getUserId();
            if (userId != null) {
                map.put(SedisPaper.PAPER_USERID, userId.toString());
            }
            Long courseId = model.getCourseId();
            if (courseId != null) {
                map.put(SedisPaper.PAPER_COURSEID, courseId.toString());
            }
            Date createTime = model.getCreateTime();
            if (createTime != null) {
                map.put(SedisPaper.PAPER_CREATETIME, createTime.toString());
            }
            Integer paperType = model.getPaperType();
            if (paperType != null) {
                map.put(SedisPaper.PAPER_PAPERTYPE, paperType.toString());
            }
            Integer schoolId = model.getSchoolId();
            if (schoolId != null) {
                map.put(SedisPaper.PAPER_SCHOOLID, schoolId.toString());
            }
            // 存入缓存
            jedisTemplate.hmset(redisKey, map);
            jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
        }
    }
}
