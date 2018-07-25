package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.toolkit.jedis.template.JedisExecutor;
import com.zhihuishu.toolkit.jedis.template.JedisTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    public JedisTemplate jedisTemplate;
    @Autowired
    public JedisExecutor jedisExecutor;

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
}

