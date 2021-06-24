package com.example.listossimage.controller;

import com.example.listossimage.service.ImageOssService;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "ImageOssController", description = "图片上传OSS返回URL接口")
@RestController
@RequestMapping("/imageoss")
public class ImageOssController {

    @Autowired
    private ImageOssService imageOssService;

    @ApiOperation("上传图片")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestBody MultipartFile multipartFile, String fileMessage) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, IOException {
        if(multipartFile == null && fileMessage == null && "".equals(fileMessage)) {
            return "您还未输入完全，请输入完全的信息！";
        }
        return imageOssService.upload(multipartFile, fileMessage);
    }
}
