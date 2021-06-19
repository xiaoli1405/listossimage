package com.example.listossimage.service;

import com.aliyun.oss.OSSClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 闪传oss服务接口
 */
public interface OssImageService {

    public String upload(MultipartFile multipartFile) throws IOException;
}
