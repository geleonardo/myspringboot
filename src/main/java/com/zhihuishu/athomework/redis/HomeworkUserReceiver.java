package com.zhihuishu.athomework.redis;


import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.dto.HomeworkAnswerDto;
import com.zhihuishu.athomework.dto.HomeworkUserDto;
import com.zhihuishu.athomework.service.HomeworkAnswerService;
import com.zhihuishu.athomework.service.HomeworkUserService;
import com.zhihuishu.toolkit.jedis.template.JedisTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


public class HomeworkUserReceiver {

    @Resource
    private HomeworkAnswerService homeworkAnswerService;

    @Resource
    private HomeworkUserService homeworkUserService;

    @Autowired
    private JedisTemplate jedisTemplate;

    @RabbitHandler
    public void process() {

        while (true) {
            List<String> str = jedisTemplate.brpop(0, RedisKey.generateHomeworkUserQueueKey());
            if (!str.isEmpty() && str.size() >= 2 && StringUtils.isNotEmpty(str.get(1))) {

               HomeworkUserDto homeworkUserDto =homeworkUserService.getHomeworkUserByRedisKey(str.get(1));
                if(homeworkUserDto!=null)
                {
                    homeworkUserService.updateHomeworkUserByID(homeworkUserDto);
                }

            }
        }


    }




}
