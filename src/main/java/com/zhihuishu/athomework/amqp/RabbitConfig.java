package com.zhihuishu.athomework.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue HomeworkAnswerQueue(){return new Queue("homeworkAnswerQueue");}

    @Bean
    public Queue HomeworkUserQueue(){return new Queue("homeworkUserQueue");}
}
