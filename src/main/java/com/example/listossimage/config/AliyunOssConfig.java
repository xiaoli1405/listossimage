package com.example.listossimage.config;

/**
 * 阿里云配置类
 */

public enum  AliyunOssConfig {

    ALIYUN_OSS_ENDPOINT("oss-cn-beijing.aliyuncs.com"),

    ALIYUN_OSS_ACCESSKEYID("LTAI5tCfswAWmLudFFrxRAQn"),

    ALIYUN_OSS_ACCESSKEYSECRET("NxeyxAtD4m08JeKBu7aQwsLqS05GG2"),

    ALIYUN_OSS_BUCKETNAME("lst-oss");

    private String s;

    AliyunOssConfig(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

}
