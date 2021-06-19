package com.example.listossimage.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class XmlUtil {
    public static void deleteFile(File... files) {
        for (File file : files) {
            //logger.info("File:[{}]",file.getAbsolutePath());
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static File ossUpload(MultipartFile file) throws IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        File excelFile = File.createTempFile(UUID.randomUUID().toString(), prefix);
        // MultipartFile to File
        file.transferTo(excelFile);
        //程序结束时，删除临时文件
        return excelFile;
    }
}
