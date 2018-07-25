package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.constant.SedisHomeworkUser;
import com.zhihuishu.athomework.dto.HomeworkAnswerDto;
import com.zhihuishu.athomework.dto.HomeworkUserDto;
import com.zhihuishu.athomework.mapper.cluster.HomeworkUserMapper;

import com.zhihuishu.athomework.model.homework.HomeworkUser;
import com.zhihuishu.athomework.redis.RedisKeyUtil;
import com.zhihuishu.athomework.service.HomeworkUserService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeworkUserServiceImpl extends BaseService implements HomeworkUserService{

    @Resource
    private HomeworkUserMapper homeworkUserMapper;

    @Override
    public List<HomeworkUserDto> queryHomeworkUser(long userId) {
        List<HomeworkUserDto> List=null;
        try {
            List= homeworkUserMapper.queryHomeworkUser(userId);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  List;
    }


    public HomeworkUserDto getHomeworkUserBySingle(long userId, long homeworkId, long paperId) {
        HomeworkUserDto model=null;
        try {

            model= homeworkUserMapper.getHomeworkUserBySingle(userId,homeworkId,paperId);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  model;
    }
    @Override
    public List<HomeworkUserDto> queryHomeworkUserByHPID(long homeworkId, long paperId) {
        List<HomeworkUserDto> List=null;
        try {
            List= homeworkUserMapper.queryHomeworkUserByHPID(homeworkId,paperId);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  List;
    }


    @Override
    public Boolean updateHomeworkUserByID(HomeworkUserDto homeworkUserDto) {
        Integer result = -1;
        try {
            Assert.notNull(homeworkUserDto.getId(), "id不能为空");
            result = homeworkUserMapper.updateHomeworkUserByID(homeworkUserDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result>0;
    }

    @Override
    public HomeworkUserDto getHomeworkUserByRedisKey(String homeworkUserRedisKey)
    {
        HomeworkUserDto homeworkAnswerDto=null;
        Map<String, String> homeworkAnswerMap = jedisTemplate.hgetAll(homeworkUserRedisKey);
        homeworkAnswerDto=getRedis_HomeworkUserModel(homeworkAnswerMap);
        return  homeworkAnswerDto;
    }

    //新增作业考试初始数据（仅教师端调用）
    @Override
    public Boolean insertHomeworkUser(long userId,long homeworkId,long paperId) {

        Integer result = -1;
        try {
            HomeworkUserDto homeworkUserDto=new HomeworkUserDto();
            homeworkUserDto.setUserId(userId);
            homeworkUserDto.setHomeworkId(homeworkId);
            homeworkUserDto.setPaperId(paperId);
            //作业状态(1 新作业；2暂存；3提交；4打回；5批阅完成；6成绩发放
            homeworkUserDto.setStatus(1);
            //写入数据库
            result = homeworkUserMapper.insertHomeworkUser(homeworkUserDto);
            //写入Redis
            setRedis_HomeworkUSerModel(homeworkUserDto, RedisKey.generateHomeworkUserKey(homeworkUserDto.getHomeworkId(),
                    homeworkUserDto.getPaperId(),homeworkUserDto.getUserId()));

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return result>0;

    }


    private HomeworkUserDto getRedis_HomeworkUserModel(Map<String, String> mapHomeworkUser)
    {
        HomeworkUserDto homeworkUserDto =new HomeworkUserDto();
        String id=mapHomeworkUser.get(SedisHomeworkUser.ID);
        String homeworkId=mapHomeworkUser.get(SedisHomeworkUser.HOMEWORKID);
        String paperId=mapHomeworkUser.get(SedisHomeworkUser.PAPERID);
        String userId=mapHomeworkUser.get(SedisHomeworkUser.USERID);
        String status=mapHomeworkUser.get(SedisHomeworkUser.STATUS);
        String isDelay=mapHomeworkUser.get(SedisHomeworkUser.ISDELAY);
        String subjectiveScore=mapHomeworkUser.get(SedisHomeworkUser.SUBJECTIVESCORE);
        String objectiveScore=mapHomeworkUser.get(SedisHomeworkUser.OBJECTIVESCORE);
        String deduct=mapHomeworkUser.get(SedisHomeworkUser.DEDUCT);
        String submitTime=mapHomeworkUser.get(SedisHomeworkUser.SUBMITTIME);
        String similar=mapHomeworkUser.get(SedisHomeworkUser.SIMILAR);
        String remark=mapHomeworkUser.get(SedisHomeworkUser.REMARK);

        if(StringUtils.isNotEmpty(id))
        {
            homeworkUserDto.setId(Long.valueOf(id));
        }
        if(StringUtils.isNotEmpty(homeworkId))
        {
            homeworkUserDto.setHomeworkId(Long.valueOf(homeworkId));
        }
        if(StringUtils.isNotEmpty(paperId))
        {
            homeworkUserDto.setPaperId(Long.valueOf(paperId));
        }
        if(StringUtils.isNotEmpty(userId))
        {
            homeworkUserDto.setUserId(Long.valueOf(userId));
        }
        if(StringUtils.isNotEmpty(status))
        {
            homeworkUserDto.setStatus(Integer.valueOf(status));
        }
        if(StringUtils.isNotEmpty(isDelay))
        {
            homeworkUserDto.setIsDelay(Integer.valueOf(status));
        }
        if(StringUtils.isNotEmpty(subjectiveScore))
        {
            homeworkUserDto.setSubjectiveScore(Double.valueOf(subjectiveScore));
        }
        if(StringUtils.isNotEmpty(objectiveScore))
        {
            homeworkUserDto.setSubjectiveScore(Double.valueOf(objectiveScore));
        }
        if(StringUtils.isNotEmpty(deduct))
        {
            homeworkUserDto.setDeduct(Double.valueOf(deduct));
        }
        if(StringUtils.isNotEmpty(submitTime))
        {
            homeworkUserDto.setDeduct(Double.valueOf(deduct));
        }
        if(StringUtils.isNotEmpty(submitTime))
        {
            homeworkUserDto.setSubmitTime(Date.valueOf(submitTime));
        }
        if(StringUtils.isNotEmpty(similar))
        {
            homeworkUserDto.setSimilar(Integer.valueOf(similar));
        }
        if(StringUtils.isNotEmpty(remark))
        {
            homeworkUserDto.setRemark(remark);
        }

        return  homeworkUserDto;
    }


    private void setRedis_HomeworkUSerModel(HomeworkUserDto homeworkUserDto,String redisKey )
    {
        if (homeworkUserDto != null) {

            Map<String, String> map = new HashMap<String, String>();
            Long id = homeworkUserDto.getId();
            if (id != null) {
                map.put(SedisHomeworkUser.ID, id.toString());
            }
            Long homeworkId = homeworkUserDto.getHomeworkId();
            if (homeworkId != null) {
                map.put(SedisHomeworkUser.HOMEWORKID, homeworkId.toString());
            }
            Long paperId = homeworkUserDto.getPaperId();
            if (paperId != null) {
                map.put(SedisHomeworkUser.PAPERID, paperId.toString());
            }
            Long userId = homeworkUserDto.getUserId();
            if (userId != null) {
                map.put(SedisHomeworkUser.USERID, userId.toString());
            }
            Integer status = homeworkUserDto.getStatus();
            if (status != null) {
                map.put(SedisHomeworkUser.STATUS, status.toString());
            }
            Integer isDelay = homeworkUserDto.getIsDelay();
            if (isDelay != null) {
                map.put(SedisHomeworkUser.ISDELAY, isDelay.toString());
            }
            Double subjectiveScore = homeworkUserDto.getSubjectiveScore();
            if (subjectiveScore != null) {
                map.put(SedisHomeworkUser.SUBJECTIVESCORE, subjectiveScore.toString());
            }
            Double objectiveScore = homeworkUserDto.getObjectiveScore();
            if (objectiveScore != null) {
                map.put(SedisHomeworkUser.OBJECTIVESCORE, objectiveScore.toString());
            }
            Double deduct = homeworkUserDto.getDeduct();
            if (deduct != null) {
                map.put(SedisHomeworkUser.DEDUCT, deduct.toString());
            }
            Date submitTime = homeworkUserDto.getSubmitTime();
            if (submitTime != null) {
                map.put(SedisHomeworkUser.SUBMITTIME, submitTime.toString());
            }
            Integer similar = homeworkUserDto.getSimilar();
            if (similar != null) {
                map.put(SedisHomeworkUser.SIMILAR, similar.toString());
            }
            String remark = homeworkUserDto.getRemark();
            if (remark != null) {
                map.put(SedisHomeworkUser.REMARK, remark);
            }

            // 存入缓存
            jedisTemplate.hmset(redisKey, map);
            jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
        }

    }

}
