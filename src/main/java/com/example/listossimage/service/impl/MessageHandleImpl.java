package com.example.listossimage.service.impl;

import com.example.listossimage.entity.Image;
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
    private ImageRepository imageRepository;

    @Override
    public String handleMessage(MessageExt msg) throws UnsupportedEncodingException {
        String body = new String(msg.getBody(), "utf-8");
        //分割字符串
        String[] split = body.split(",");
        String fileName = split[0];
        String url = split[1];
        System.out.println(fileName+"  "+url);
        Image image = new Image();
        image.setImgText(fileName);
        image.setImgUrl(url);
        imageRepository.save(image);
        return null;
    }
}
