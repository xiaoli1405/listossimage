package com.example.listossimage.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.example.listossimage.component.RocketMQProducer;
import com.example.listossimage.config.AliyunOssConfig;
import com.example.listossimage.config.RocketMQConfig;
import com.example.listossimage.service.ImageOssService;
import com.example.listossimage.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class ImageOssServiceImpl implements ImageOssService {


    private String ALIYUN_OSS_ENDPOINT = AliyunOssConfig.ALIYUN_OSS_ENDPOINT.getS();

    private String ALIYUN_OSS_ACCESSKEYID = AliyunOssConfig.ALIYUN_OSS_ACCESSKEYID.getS();

    private String ALIYUN_OSS_ACCESSKEYSECRET = AliyunOssConfig.ALIYUN_OSS_ACCESSKEYSECRET.getS();

    private String ALIYUN_OSS_BUCKETNAME = AliyunOssConfig.ALIYUN_OSS_BUCKETNAME.getS();

    @Autowired
    private RedisService redisService;

    @Autowired
    private RocketMQProducer producer;

    @Override
    public String upload(MultipartFile multipartFile) throws IOException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        //初始化OSSClient
        OSSClient ossClient = new OSSClient(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID, ALIYUN_OSS_ACCESSKEYSECRET);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        //获取文件名
        String originalFilename = multipartFile.getOriginalFilename();
        //获取文件后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成最终文件名
        String finalFileName = System.currentTimeMillis() + "" + new SecureRandom().nextInt(0x0400) + substring;

        //OSS中文件的名字
        String objectFileName = simpleDateFormat.format(new Date()) + "/" + finalFileName;
        //创建上传文件的元信息
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/jpg");

        //文件上传
        ossClient.putObject(ALIYUN_OSS_BUCKETNAME, objectFileName, new ByteArrayInputStream(multipartFile.getBytes()), objectMetadata);
        //设置文件过期时间
        Date dateToLate = new Date(System.currentTimeMillis() + 3600 * 1000);
        String url = ossClient.generatePresignedUrl(ALIYUN_OSS_BUCKETNAME, objectFileName, dateToLate).toString();

        //关闭OSSClient
        ossClient.shutdown();

        //上传成功后将文件名和URL保存到Redis缓存中去
        redisService.set("objectFileName", originalFilename + "," + url);


        //将缓存中的KEY值放入队列当中
        //创建生产信息
        Message message = new Message(RocketMQConfig.TOPIC, "testtag", finalFileName.getBytes());
        //发送信息
        SendResult send = producer.getProducer().send(message);

//        rocketMQTemplate.convertAndSend(RocketMQConfig.TOPIC, finalFileName);
//        //关闭生产者
//        rocketMQTemplate.destroy();
        log.info("输出生产者信息={}", send);

        return url;
    }
}
