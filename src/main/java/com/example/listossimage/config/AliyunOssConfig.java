package com.example.listossimage.config;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 阿里云配置类
 */
@Configuration
public class AliyunOssConfig {
//    // 地域节点
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//    @Value("${aliyun.accessKeyId}")
//    private String accessKeyId;
//    @Value("${aliyun.accessKeySecret}")
//    private String accessKeySecret;
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName;
//    @Value("${aliyun.oss.urlPrefix}")
//    private String urlPrefix;
//
//    @Bean
//    public OSSClient ossClient() {
//        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
//    }
}
