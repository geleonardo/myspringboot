package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.mapper.master.PaperQuestionMapper;
import com.zhihuishu.athomework.redis.RedisKeyUtil;
import com.zhihuishu.athomework.service.PaperQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaperQuestionServiceImpl extends BaseService implements PaperQuestionService {

    @Resource
    private PaperQuestionMapper paperQuestionMapper;

    @Override
    public List<String> findPaperQuestionIDS(Long groupId) {
        List<String> questionIds = null;
        try {
            String redisKey = RedisKey.generatePaperQuestionIDSKey(groupId);
            questionIds = jedisTemplate.lrange(redisKey, 0, -1);
            if (!jedisTemplate.exists(redisKey)) {
                questionIds = paperQuestionMapper.findPaperQuestionIDS(groupId);
                if (questionIds != null && !questionIds.isEmpty()) {
                    jedisTemplate.lpush(redisKey, questionIds);
                    jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questionIds;
    }
}
