package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.redis.HomeworkAnswerReceiver;
import com.zhihuishu.athomework.redis.HomeworkAnswerSender;
import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.constant.SedisHomeworkAnswer;
import com.zhihuishu.athomework.dto.HomeworkAnswerDto;
import com.zhihuishu.athomework.mapper.cluster.HomeworkAnswerMapper;
import com.zhihuishu.athomework.redis.RedisKeyUtil;
import com.zhihuishu.athomework.service.HomeworkAnswerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.HashMap;
import java.util.Map;

@Service
public class HomeworkAnswerServiceImpl extends  BaseService implements HomeworkAnswerService {

    HomeworkAnswerMapper homeworkAnswerMapper;


    private HomeworkAnswerSender homeworkAnswerSender;

    private HomeworkAnswerReceiver setHomeworkAnswerReceiver;

    @Override
    public Boolean isExists(Long homeworkId,Long paperId,Long userId,Long questionId) {
        Boolean b=false;
        try{

            String Id=homeworkAnswerMapper.findHomeworkAnswerID(homeworkId,paperId,userId,questionId);
            b=StringUtils.isNoneEmpty(Id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  b;
    }

    @Override
    public HomeworkAnswerDto getHomeworkAnswerByID(Long homeworkId,Long paperId,Long userId,Long questionId) {

        HomeworkAnswerDto homeworkAnswerDto=null;
        String homeworkAnswerRedisKey = RedisKey.generateHomeworkAnswerKey(homeworkId,paperId,userId,questionId);
        Map<String, String> homeworkAnswerMap = jedisTemplate.hgetAll(homeworkAnswerRedisKey);
        if (homeworkAnswerMap!=null && !homeworkAnswerMap.isEmpty())
        {
            homeworkAnswerDto=getRedis_HomeworkAnswerModel(homeworkAnswerMap);
        }
        else
        {
            homeworkAnswerDto= homeworkAnswerMapper.getHomeworkAnswerByID(homeworkId,paperId,userId,questionId);
            setRedis_HomeworkAnswerModel(homeworkAnswerDto,homeworkAnswerRedisKey);
        }

        return homeworkAnswerDto;
    }

    @Override
    public  void  setHomeworkAnswer(HomeworkAnswerDto homeworkAnswerDto)
    {
        String homeworkAnswerRedisKey = RedisKey.generateHomeworkAnswerKey(homeworkAnswerDto.getHomeworkId(),
                homeworkAnswerDto.getPaperId(),homeworkAnswerDto.getUserId(),homeworkAnswerDto.getQuestionId());

        //算得分
        //homeworkAnswerDto=calculateHomeworkAnswerScore(homeworkAnswerDto);

        //存缓存
        setRedis_HomeworkAnswerModel(homeworkAnswerDto,homeworkAnswerRedisKey);

        //异步入库
        homeworkAnswerSender.send(homeworkAnswerRedisKey);
        setHomeworkAnswerReceiver.process();
    }


    @Override
    public HomeworkAnswerDto  calculateHomeworkAnswerScore(HomeworkAnswerDto homeworkAnswerDto )
    {

        if(homeworkAnswerDto !=null)
        {
                //算得分

        }

        return homeworkAnswerDto;
    }

    @Override
    public  HomeworkAnswerDto getHomeworkAnswerByRedisKey(String homeworkAnswerRedisKey)
    {

        HomeworkAnswerDto homeworkAnswerDto=null;
        Map<String, String> homeworkAnswerMap = jedisTemplate.hgetAll(homeworkAnswerRedisKey);
        homeworkAnswerDto=getRedis_HomeworkAnswerModel(homeworkAnswerMap);
        return  homeworkAnswerDto;
    }


    @Override
    public Integer updateHomeworkAnswer(HomeworkAnswerDto homeworkAnswerDto ) {

        Integer result = -1;
        try {
            Assert.notNull(homeworkAnswerDto.getId(), "id不能为空");
            result = homeworkAnswerMapper.updateHomeworkAnswer(homeworkAnswerDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public Integer insertHomeworkAnswer(HomeworkAnswerDto homeworkAnswerDto) {
        Integer result = -1;
        try {
            result = homeworkAnswerMapper.insertHomeworkAnswer(homeworkAnswerDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    private HomeworkAnswerDto getRedis_HomeworkAnswerModel(Map<String, String> mapHomeworkAnswer)
    {
        HomeworkAnswerDto homeworkAnswerDto =new HomeworkAnswerDto();
        String id=mapHomeworkAnswer.get(SedisHomeworkAnswer.ID);
        String homeworkId=mapHomeworkAnswer.get(SedisHomeworkAnswer.HOMEWORKID);
        String paperId=mapHomeworkAnswer.get(SedisHomeworkAnswer.PAPERID);
        String questionId=mapHomeworkAnswer.get(SedisHomeworkAnswer.QUESTIONID);
        String userId=mapHomeworkAnswer.get(SedisHomeworkAnswer.USERID);
        String answer=mapHomeworkAnswer.get(SedisHomeworkAnswer.ANSWER);
        String score=mapHomeworkAnswer.get(SedisHomeworkAnswer.SCORE);

        if(StringUtils.isNotEmpty(id))
        {
            homeworkAnswerDto.setId(Long.valueOf(id));
        }
        if(StringUtils.isNotEmpty(homeworkId))
        {
            homeworkAnswerDto.setHomeworkId(Long.valueOf(homeworkId));
        }
        if(StringUtils.isNotEmpty(paperId))
        {
            homeworkAnswerDto.setPaperId(Long.valueOf(paperId));
        }
        if(StringUtils.isNotEmpty(questionId))
        {
            homeworkAnswerDto.setQuestionId(Long.valueOf(questionId));
        }
        if(StringUtils.isNotEmpty(userId))
        {
            homeworkAnswerDto.setUserId(Long.valueOf(userId));
        }
        if(StringUtils.isNotEmpty(answer))
        {
            homeworkAnswerDto.setAnswer(answer);
        }
        if(StringUtils.isNotEmpty(score))
        {
            homeworkAnswerDto.setScore(Double.valueOf(score));
        }
        return  homeworkAnswerDto;
    }

    private void setRedis_HomeworkAnswerModel(HomeworkAnswerDto homeworkAnswerDto,String redisKey )
    {
        if (homeworkAnswerDto != null) {

            Map<String, String> map = new HashMap<String, String>();
            Long id = homeworkAnswerDto.getId();
            if (id != null) {
                map.put(SedisHomeworkAnswer.ID, id.toString());
            }
            Long homeworkId = homeworkAnswerDto.getHomeworkId();
            if (homeworkId != null) {
                map.put(SedisHomeworkAnswer.HOMEWORKID, homeworkId.toString());
            }
            Long paperId = homeworkAnswerDto.getPaperId();
            if (paperId != null) {
                map.put(SedisHomeworkAnswer.PAPERID, paperId.toString());
            }
            Long questionId = homeworkAnswerDto.getQuestionId();
            if (questionId != null) {
                map.put(SedisHomeworkAnswer.QUESTIONID, questionId.toString());
            }
            String answer = homeworkAnswerDto.getAnswer();
            if (StringUtils.isNoneEmpty(answer) ) {
                map.put(SedisHomeworkAnswer.ANSWER, answer);
            }
            Double score = homeworkAnswerDto.getScore();
            if (score != null) {
                map.put(SedisHomeworkAnswer.SCORE, score.toString());
            }

            // 存入缓存
            jedisTemplate.hmset(redisKey, map);
            jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
        }

    }

}
