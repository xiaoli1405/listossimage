package com.example.listossimage.controller;

import com.example.listossimage.entity.Image;
import com.example.listossimage.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "ImageController", description = "测试基础框架搭建接口")
@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Resource
    private ImageService imageService;

    @ApiOperation("获取数据库的图片信息")
    @RequestMapping(value = "/getimage", method = RequestMethod.GET)
    public List<Image> getImage() {
        return imageService.GetImage();
    }
}
