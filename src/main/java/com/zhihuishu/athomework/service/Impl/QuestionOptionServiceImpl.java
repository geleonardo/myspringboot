package com.zhihuishu.athomework.service.Impl;

import com.alibaba.fastjson.JSON;
import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.dto.QuestionOptionDto;
import com.zhihuishu.athomework.mapper.master.QuestionOptionMapper;
import com.zhihuishu.athomework.service.QuestionOptionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionOptionServiceImpl extends BaseService implements QuestionOptionService {

    @Resource
    private QuestionOptionMapper questionOptionMapper;

    @Override
    public List<QuestionOptionDto> findOptionByQuesId(Long questionId) {
        List<QuestionOptionDto> quesOptionDtoList = null;

        try {
            String quesOptionRedisKey = RedisKey.generateQuestionOptionKey(questionId);
            String quesOptionListJson = jedisTemplate.get(quesOptionRedisKey);

            if(StringUtils.isEmpty(quesOptionListJson)){
                quesOptionDtoList = questionOptionMapper.findOptionByQuesId(questionId);
                if(!CollectionUtils.isEmpty(quesOptionDtoList)){
                    jedisTemplate.set(quesOptionRedisKey, JSON.toJSONString(quesOptionDtoList));
                }
            } else {
                quesOptionDtoList = JSON.parseArray(quesOptionListJson, QuestionOptionDto.class);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return quesOptionDtoList;
    }

    @Override
    public Integer saveOptionBatch(List<QuestionOptionDto> questionOptionDtoList) {
        return questionOptionMapper.saveOptionBatch(questionOptionDtoList);
    }

    @Override
    public Integer delOptionBatch(Long[] questionOptionIds) {
        return questionOptionMapper.delOptionBatch(questionOptionIds);
    }
}
