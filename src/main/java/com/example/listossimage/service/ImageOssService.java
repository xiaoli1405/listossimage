package com.example.listossimage.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传到OSS的service接口
 */
public interface ImageOssService {

    /**
     * 上传
     * @param multipartFile
     * @return
     */
    public String upload(MultipartFile multipartFile, String fileMessage) throws IOException, InterruptedException, RemotingException, MQClientException, MQBrokerException;
}
