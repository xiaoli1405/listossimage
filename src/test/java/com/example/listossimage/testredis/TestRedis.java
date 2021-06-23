package com.example.listossimage.testredis;

import com.example.listossimage.ListossimageApplicationTests;
import com.example.listossimage.service.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestRedis extends ListossimageApplicationTests {

    @Autowired
    RedisService redisService;

    /**
     * 测试redis连接是否成功，测试缓存是否正常
     */
    @Test
    public void testRedis() {
        redisService.set("123", "123");
        System.out.println(redisService.get("123"));
    }
}
