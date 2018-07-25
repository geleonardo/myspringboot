package com.zhihuishu.athomework.redis;

import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.toolkit.jedis.template.JedisTemplate;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class HomeworkUserSender {

    @Autowired
    private JedisTemplate jedisTemplate;

    public void send(String homeworkUserKey) {

        jedisTemplate.lpush( RedisKey.generateHomeworkUserQueueKey(), homeworkUserKey);


    }
}
