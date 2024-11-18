package springbootfilter.Util;

import com.aliyun.oss.OSS;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import springbootfilter.config.OssConfig;


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
//            String fileName = UUID.randomUUID().toString() + "_" + originalFilename;
            String fileName =  "是否超过限定尺寸" + originalFilename;
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(ossConfig.getBucket(), fileName,inputStream);
            return "http://"+ossConfig.getBucket()+"."+ossConfig.getEndpoint().replace("http://","")+"/"+fileName;


        }catch(Exception e){
            throw new RuntimeException("文件上传失败",e);
        }
    }
}
