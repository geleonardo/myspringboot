package com.zhihuishu.athomework.redis;


import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.dto.HomeworkAnswerDto;
import com.zhihuishu.athomework.service.HomeworkAnswerService;
import com.zhihuishu.toolkit.jedis.template.JedisTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class HomeworkAnswerReceiver {

    @Resource
    private HomeworkAnswerService homeworkAnswerService;

    @Autowired
    private JedisTemplate jedisTemplate;

    public void process() {


        Boolean flat=true;
        while (flat)
        {
            List<String> str = jedisTemplate.brpop(0, RedisKey.generateHomeworkAnswerQueueKey());
            if(!str.isEmpty() && str.size() >=2 && StringUtils.isNotEmpty(str.get(1))){


                HomeworkAnswerDto homeworkAnswerDto=homeworkAnswerService.getHomeworkAnswerByRedisKey(str.get(1));

                if(homeworkAnswerService.isExists(homeworkAnswerDto.getHomeworkId(),
                        homeworkAnswerDto.getPaperId(),homeworkAnswerDto.getUserId(),homeworkAnswerDto.getQuestionId()))
                {
                    homeworkAnswerService.updateHomeworkAnswer(homeworkAnswerDto);
                }
                else
                {
                    homeworkAnswerService.insertHomeworkAnswer(homeworkAnswerDto);
                }

            }
            else
            {
                flat=false;

            }

        }



    }

}
