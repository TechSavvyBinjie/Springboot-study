package springbootfile.util;

import org.junit.jupiter.api.Test;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

@SpringBootTest
@Slf4j
class MinIoTemplateTest {

    @Resource
    private MinioTemplate minIoTemplate;

    @Test
    void bucketExists() throws Exception {
        // 判断是否有 avatar 这个存储桶存在
        boolean flag = minIoTemplate.bucketExists("avatar");
        log.info(String.valueOf(flag));
    }

    @Test
    void makeBucket() throws Exception {
        // 创建一个名为 mqxu 的存储桶
        minIoTemplate.makeBucket("mqxu");
    }

    @Test
    void putObject() throws Exception {
        File file = new File("D:/360极速浏览器X下载/_temp_matlab_R2022b_win64/OneDrive/Pictures/20210119134525_gdcjs.jpg");;
        // 返回上传后的访问路径
        String url = minIoTemplate.putObject("mqxu", "test/" + UUID.randomUUID() + ".png", new FileInputStream(file));
        log.info(url);
    }

    @Test
    void removeObject() throws Exception {
        // 移除指定的文件（存在）
        minIoTemplate.removeObject("mqxu", "img/test.jpg");
    }
}