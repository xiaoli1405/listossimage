package com.example.listossimage.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.example.listossimage.config.AliyunOssConfig;
import com.example.listossimage.service.OssImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class OssImageServiceImpl implements OssImageService {

    private String ALIYUN_OSS_ENDPOINT = AliyunOssConfig.ALIYUN_OSS_ENDPOINT.getS();

    private String ALIYUN_OSS_ACCESSKEYID = AliyunOssConfig.ALIYUN_OSS_ACCESSKEYID.getS();

    private String ALIYUN_OSS_ACCESSKEYSECRET = AliyunOssConfig.ALIYUN_OSS_ACCESSKEYSECRET.getS();

    private String ALIYUN_OSS_BUCKETNAME = AliyunOssConfig.ALIYUN_OSS_BUCKETNAME.getS();

    //初始化OSSClient
    OSSClient ossClient = new OSSClient(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID, ALIYUN_OSS_ACCESSKEYSECRET);

    @Override
    public String upload(MultipartFile file) throws IOException {
        OSSClient ossClient = new OSSClient(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID, ALIYUN_OSS_ACCESSKEYSECRET);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 最后上传生成的文件名
        String finalFileName = System.currentTimeMillis() + "" + new SecureRandom().nextInt(0x0400) + suffixName;
        // oss中的文件夹名
        String objectName = sdf.format(new Date()) + "/" + finalFileName;
        // 创建上传文件的元信息，可以通过文件元信息设置HTTP header(设置了才能通过返回的链接直接访问)。
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/jpg");
        // 文件上传
        ossClient.putObject(ALIYUN_OSS_BUCKETNAME, objectName, new ByteArrayInputStream(file.getBytes()), objectMetadata);
        // 设置URL过期时间为1小时。
        Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
        String url = ossClient.generatePresignedUrl(ALIYUN_OSS_BUCKETNAME, objectName, expiration).toString();
        ossClient.shutdown();
        log.info("阿里云OSS的文件url:{}", url);
        return url;
    }
}
