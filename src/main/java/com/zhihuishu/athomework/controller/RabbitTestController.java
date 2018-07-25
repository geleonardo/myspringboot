package com.zhihuishu.athomework.controller;

import com.zhihuishu.athomework.amqp.HelloSender1;
import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.toolkit.jedis.template.JedisTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/rabbit")
public class RabbitTestController {

    @Autowired
    private JedisTemplate jedisTemplate;

    @Autowired
    private HelloSender1 testSender;

    @RequestMapping("/hello")
    public void hello() {
     //   testSender.send();

        /*jedisTemplate.lpush("athomework:test:hello", "1");
        jedisTemplate.lpush("athomework:test:hello", "2");

        List<String> str = jedisTemplate.brpop(0,"athomework:test:hello");
        if(!str.isEmpty() && str.size() == 2 && StringUtils.isNotEmpty(str.get(1))){
            System.out.println(str.get(1));
        }
*/
        jedisTemplate.lpush( RedisKey.generateHomeworkAnswerQueueKey(), "1");
        jedisTemplate.lpush( RedisKey.generateHomeworkAnswerQueueKey(), "2");
        jedisTemplate.lpush( RedisKey.generateHomeworkAnswerQueueKey(), "3");
        jedisTemplate.lpush( RedisKey.generateHomeworkAnswerQueueKey(), "4");
        jedisTemplate.lpush( RedisKey.generateHomeworkAnswerQueueKey(), "5");
        jedisTemplate.lpush( RedisKey.generateHomeworkAnswerQueueKey(), "6");


        Boolean flat=true;
        while (flat)
        {


            List<String> str = jedisTemplate.brpop(0, RedisKey.generateHomeworkAnswerQueueKey());
            if(!str.isEmpty() && str.size() >=2 && StringUtils.isNotEmpty(str.get(1))){

                System.out.println(str.get(1));
            }
            else
            {
                flat=false;

            }

        }



    }
}