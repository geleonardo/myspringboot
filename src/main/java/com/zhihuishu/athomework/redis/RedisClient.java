package com.zhihuishu.athomework.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述：redis工具类
 * 对于redisTpl.opsForValue().set(key, value)进行了一次封装，不然每次都要这样保存值
 * 而封装后只需：new RedisClient().set(key,value);
 * StringRedisTemplate 的使用方法参照
 * https://blog.csdn.net/qq_35357001/article/details/77966861
 * https://www.cnblogs.com/yanan7890/p/6617305.html
 */
@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate redisTpl; //redisTpl

    // 功能描述：设置key-value到redis中
    public boolean set(String key ,String value){
        try{
            redisTpl.opsForValue().set(key, value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // 功能描述：通过key获取缓存里面的值
    public String get(String key){
        return redisTpl.opsForValue().get(key);
    }

    // 功能描述：设置key-value到redis中,并设置超时时间
    public boolean setvithexpire(String key ,String value,Integer time){
        try{
            redisTpl.opsForValue().set(key, value,time,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


}