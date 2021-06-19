package com.example.listossimage.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.UploadFileRequest;

import java.io.File;
import java.io.FileNotFoundException;

public class OssUtils {
    // 创建存储空间，Endpoint以杭州为例，其它Region请按实际情况填写。
    private String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    private String accessId = "<yourAccessKeyId>";
    private String accessKey = "<yourAccessKeySecret>";
    private String privateDomain = "<yourPrivateDomain >";
    private String privateBucket = "<yourBucketName>";


    public void ossUpload(String fileName, File file, String contentType) {
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessKey);
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType(contentType);
            UploadFileRequest uploadFileRequest = new UploadFileRequest(privateBucket, fileName);
            // 指定上传的本地文件。
            uploadFileRequest.setUploadFile(file.toString());
            // 指定上传并发线程数，默认为1。
            uploadFileRequest.setTaskNum(5);
            // 指定上传的分片大小，范围为100KB~5GB，默认为文件大小/10000。
            uploadFileRequest.setPartSize(1 * 1024 * 1024);
            // 开启断点续传，默认关闭。
            uploadFileRequest.setEnableCheckpoint(true);
            uploadFileRequest.setCheckpointFile("uploadFile.ucp");
            // 文件的元数据。
            uploadFileRequest.setObjectMetadata(meta);
            // 设置上传成功回调，参数为Callback类型。
            //uploadFileRequest.setCallback("<yourCallbackEvent>");
            // 断点续传上传。
            ossClient.uploadFile(uploadFileRequest);
            // 关闭OSSClient。
            ossClient.shutdown();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     */
    public String getContentType(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".jpg".equalsIgnoreCase(fileExtension)) {
            return "image/jpg";
        }
        if (".png".equalsIgnoreCase(fileExtension)) {
            return "image/png";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        if (".mp4".equalsIgnoreCase(fileExtension)) {
            return "video/mp4";
        }
        if (".mp3".equalsIgnoreCase(fileExtension)) {
            return "audio/mp3";
        }
        return "text/html";
    }
}
