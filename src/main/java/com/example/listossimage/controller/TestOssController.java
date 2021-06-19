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
public class TestOssController {

    @Autowired
    private OssImageService ossImageService;

    @ApiOperation("把图片上传到OSS")
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() throws IOException {

        File file = new File("E:\\360downloads\\wpcache\\srvsetwp\\2046232.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
        String url = ossImageService.upload(multipartFile);
        return url;
    }

}
