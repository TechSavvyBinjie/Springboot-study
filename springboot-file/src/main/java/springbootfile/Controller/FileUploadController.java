package springbootfile.Controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springbootfile.util.MinioTemplate;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@Slf4j
@RestController
@RequestMapping(value = "/file")
public class FileUploadController {

    @Value("${file.upload-path}")
    private String uploadPath;

    DateFormat df = new SimpleDateFormat("yyyyMMdd");

    @Resource
    private MinioTemplate miniOTemplate;

    /**
     * 本地文件上传
     * @param file 文件对象
     * @param request 请求对象
     * @return 文件上传后的地址
     */
    @PostMapping("/native")
    public String nativeUpload(MultipartFile file, HttpServletRequest request) {
        if (file != null) {
            String today = df.format(new Date());
            // 创建上传的子目录
            File folder = new File(uploadPath + "/" + today);
            if (!folder.exists()) {
                boolean flag = folder.mkdirs();
                log.info(String.valueOf(flag));
            }
            String oldFileName = file.getOriginalFilename();
            assert oldFileName != null;
            int index = oldFileName.lastIndexOf(".");
            String suffixName = oldFileName.substring(index);
            log.info("文件后缀名: {}", suffixName);
            String newFileName = UUID.randomUUID() + suffixName;
            log.info("新的文件名: {}", newFileName);
            // 文件上传
            try {
                file.transferTo(new File(folder, newFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 拼接访问地址
            return request.getScheme() + "://" + request.getServerName() +
                    ":" + request.getServerPort() + "/" + today + "/" + newFileName;
        } else {
            return "文件不能为空";
        }
    }

    /**
     * minio 文件上传
     * @param file 文件对象
     * @return 文件地址
     */
    @PostMapping("/mino")
    public String minioUpload(MultipartFile file) {
        if (file != null) {
            String url;
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            try {
                url = miniOTemplate.putObject("yangfan", "img/" + UUID.randomUUID() + suffixName, file.getInputStream());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return url;
        } else {
            return "文件不能为空";
        }
    }
}