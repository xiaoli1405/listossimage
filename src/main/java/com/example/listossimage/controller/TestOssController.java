package com.example.listossimage.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.example.listossimage.service.OssImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api(tags = "TestOssController", description = "测试图片上传OSS接口")
@RequestMapping("/oss")
@RestController
@Slf4j
public class TestOssController {


    private String ALIYUN_OSS_ENDPOINT = "oss-cn-beijing.aliyuncs.com";

    private String ALIYUN_OSS_ACCESSKEYID = "";

    private String ALIYUN_OSS_ACCESSKEYSECRET = "";

    private String ALIYUN_OSS_BUCKETNAME = "lst-oss";


    //初始化OSSClient
    OSSClient ossClient = new OSSClient(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID, ALIYUN_OSS_ACCESSKEYSECRET);

    @ApiOperation("把图片上传到OSS")
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() throws IOException {

        File file = new File("E:\\360downloads\\wpcache\\srvsetwp\\2046232.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
        String url = uploadFile(multipartFile);
        return url;
    }


    public String uploadFile(MultipartFile file) throws IOException {
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
