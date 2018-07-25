package com.zhihuishu.athomework.service.Impl;

import com.alibaba.fastjson.JSON;
import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.dto.QuestionFileDto;
import com.zhihuishu.athomework.mapper.master.QuestionFileMapper;
import com.zhihuishu.athomework.service.QuestionFileService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionFileServiceImpl extends BaseService implements QuestionFileService {

    @Resource
    private QuestionFileMapper questionFileMapper;

    @Override
    public List<QuestionFileDto> findQuesFileByQuesId(Long questionId) {
        List<QuestionFileDto> quesFileDtoList = null;

        try {
            String quesFileRedisKey = RedisKey.generateQuestionFileKey(questionId);
            String quesFileDtoListJson = jedisTemplate.get(quesFileRedisKey); //读缓存

            if(StringUtils.isEmpty(quesFileDtoListJson)){
                quesFileDtoList = questionFileMapper.findQuesFileByQuesId(questionId); //查库
                if(!CollectionUtils.isEmpty(quesFileDtoList)){
                    jedisTemplate.set(quesFileRedisKey, JSON.toJSONString(quesFileDtoList)); //放入缓存
                }
            } else {
                quesFileDtoList = JSON.parseArray(quesFileDtoListJson, QuestionFileDto.class); //取缓存
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quesFileDtoList;
    }

    @Override
    public Integer saveQuesFileBatch(List<QuestionFileDto> quesFileDtoList) {
        return questionFileMapper.saveQuesFileBatch(quesFileDtoList);
    }

    @Override
    public Integer delQuesFileByIdBatch(Long[] quesFileIds) {
        return questionFileMapper.delQuesFileByIdBatch(quesFileIds);
    }
}
