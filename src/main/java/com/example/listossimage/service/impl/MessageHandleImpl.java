package com.example.listossimage.service.impl;

import com.example.listossimage.repository.ImageRepository;
import com.example.listossimage.service.MessageHandle;
import com.example.listossimage.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Slf4j
@Service
public class MessageHandleImpl implements MessageHandle {

    @Autowired
    private RedisService redisService;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String handleMessage(MessageExt msg) throws UnsupportedEncodingException {
        String body = new String(msg.getBody(), "utf-8");
        //System.out.println(body);
        String s = redisService.get(body);
        log.info("消费者消费的信息是:",body);
        //redisService.remove(body);
        //分割字符串
        //String substring = s.substring(s.lastIndexOf(","));
        String[] split = s.split(",");
        String fileName = split[1];
        String url = split[0];

        Integer maxId = imageRepository.getMaxId() + 1;
        imageRepository.InsertImage(maxId,fileName, url);
        return null;
    }
}
