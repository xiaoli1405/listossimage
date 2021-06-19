package com.example.listossimage.controller;

import com.example.listossimage.service.RedisService;
import com.example.listossimage.service.UrlSetRedis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "TestRedisController", description = "测试redis缓存接口")
@RestController
@RequestMapping("/redis")
public class TestRedisController {

    @Autowired
    private UrlSetRedis urlSetRedis;

    @ApiOperation("把数据加入缓存")
    @RequestMapping(value = "/getredis", method = RequestMethod.GET)
    public String getRedis() {
        String redis = "redis";
        return urlSetRedis.SetRedis(redis);
    }
}
