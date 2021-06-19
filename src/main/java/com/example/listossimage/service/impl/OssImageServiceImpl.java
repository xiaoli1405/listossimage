package com.example.listossimage.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.example.listossimage.service.OssImageService;
import com.example.listossimage.util.OssUtils;
import com.example.listossimage.util.XmlUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssImageServiceImpl implements OssImageService {

    @Override
    public String upload(MultipartFile multipartFile) {
        return null;
    }
}
