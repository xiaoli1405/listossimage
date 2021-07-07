package com.example.listossimage;

import com.example.listossimage.controller.ImageOssController;
import org.apache.http.entity.ContentType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLDecoder;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ListossimageApplicationTests {

    @Autowired
    private ImageOssController imageOssController;

    /**
     * 测试本项目主要功能
     * @throws Exception
     */

    @Test
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void ImageOssTest() throws Exception {
        //构造上传的文本数据
        String textTest = "this is a image test";
        //构造上传的图像数据（本地读取上传）
        MultipartFile multipartFile = getImageFile("/static/imgs/粤X794D1featureImg.jpg");
        String upload = imageOssController.upload(multipartFile, textTest);
        Assert.assertNotNull("图片上传OSS成功", upload);//使用断言测试文件是否上传成功
        //根据url查询是否插入数据库成功
        String imageInfo = imageOssController.getImageInfo(upload);
        Assert.assertNotNull("数据已经插入成功", imageInfo);
        System.out.println("成功！");
    }

    /**
     * 根据path获取图片文件
     */

    public MultipartFile getImageFile(String path) throws IOException {
        //获取相对路径
        String filePath = this.getClass().getResource(path).getFile();
        try {
            filePath = URLDecoder.decode(filePath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        MockMultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        return multipartFile;
    }

}
