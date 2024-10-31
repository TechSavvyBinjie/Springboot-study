package com.example.springbootconfigution.util;

import com.aliyun.oss.OSS;
import com.example.springbootconfigution.config.OssConfig;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Component
public class OssUtil {
    @Resource
    private OSS ossClient;

    @Resource
    private OssConfig ossConfig;

    public String uploadFile(MultipartFile file){
        try{
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new IllegalArgumentException("");
            }
            String fileName = UUID.randomUUID().toString() + "_" + originalFilename;
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(ossConfig.getBucketName(), fileName,inputStream);
            return "http://"+ossConfig.getBucketName()+"."+ossConfig.getEndpoint().replace("http://","")+"/"+fileName;


        }catch(Exception e){
            throw new RuntimeException("文件上传失败",e);
        }
    }
}
