package com.example.listossimage.service.impl;

import com.example.listossimage.service.RedisService;
import com.example.listossimage.service.UrlSetRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SetRedisImpl implements UrlSetRedis {

    @Autowired
    private RedisService redisService;

    @Override
    public String SetRedis(String key) {
        redisService.set(key, "ceshi");
        return redisService.get(key);
    }
}
