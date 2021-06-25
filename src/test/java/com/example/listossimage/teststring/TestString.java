package com.example.listossimage.teststring;

import com.example.listossimage.entity.Image;

public class TestString {

    /**
     * 测试字符串强转成自定义对象
     * @param args
     */
    public static void main(String[] args) {
        Image image;
        Object s = "Image(imgId=null, imgUrl=http://lst-oss.oss-cn-beijing.aliyuncs.com/20210624/1624529878500302.jpg?Expires=1624533478&OSSAccessKeyId=LTAI5tCfswAWmLudFFrxRAQn&Signature=q%2Bv6nMxLApiL1hq%2F9xGAJ5FjtBo%3D, imgName=2046235.jpg, imgText=这是一张图片而已)";

        image = (Image) s;
        System.out.println(image);
    }
}
