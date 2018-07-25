package com.zhihuishu.athomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableCaching
@PropertySources({
        @PropertySource("http://conf.zhihuishu.com/athomework/mybatis.properties"),
        @PropertySource("http://conf.zhihuishu.com/athomework/mysql1.properties"),
        @PropertySource("http://conf.zhihuishu.com/athomework/rabbitmq.properties"),
        @PropertySource("http://conf.zhihuishu.com/athomework/xxljob.properties"),
        @PropertySource("http://conf.zhihuishu.com/athomework/redis.properties")
})
public class AthomeworkApplication {
    public static void main(String[] args) {
        SpringApplication.run(AthomeworkApplication.class, args);
    }
}
