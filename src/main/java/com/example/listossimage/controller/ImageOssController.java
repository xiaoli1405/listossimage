package com.example.listossimage.controller;

import com.example.listossimage.service.ImageOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "ImageOssController", description = "图片上传OSS返回URL接口")
@RestController
@RequestMapping("/imageoss")
public class ImageOssController {

    @Autowired
    private ImageOssService imageOssService;

    @ApiOperation("上传图片")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestBody MultipartFile multipartFile) {
        return imageOssService.upload(multipartFile);
    }
}
