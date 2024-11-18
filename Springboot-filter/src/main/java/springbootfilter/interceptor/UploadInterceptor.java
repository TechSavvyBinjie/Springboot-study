package springbootfilter.interceptor;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.unit.DataSizeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
@Slf4j
@Component
public class UploadInterceptor implements HandlerInterceptor {

    private static final long MAX_FILE_SIZE = 1024  *1024* 5;
    private static final int MAX_WIDTH = 1024; // 最大宽度
    private static final int MAX_HEIGHT = 1024;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否为图片格式
//        if ("POST".equalsIgnoreCase(request.getMethod()) && request.getContentType() != null && request.getContentType().startsWith("multipart/form-data")) {
//            // 获取上传的文件
//            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//            MultipartFile file = multipartRequest.getFile("file"); // 假设你的文件字段名为"file"
//            if (file != null) {
//                // 这里可以进行文件类型检测
//                String fileName = file.getOriginalFilename();
//                int index = fileName.lastIndexOf(".");
//                if (index != -1) {
//                    String suffix = fileName.substring(index + 1).toLowerCase();
//                    Set<String> imageSuffix = Set.of("jpg", "jpeg", "gif", "png", "webp");
//                    if (!imageSuffix.contains(suffix)) {
//                        response.getWriter().write("UNAUTHORIZED");
//                       return false;
//                    }
//                }
//
//            }
//        }
//        return true; // 返回true继续流程，返回false中断请求
        //判断文件大小
//        if ("POST".equalsIgnoreCase(request.getMethod()) && request.getContentType() != null && request.getContentType().startsWith("multipart/form-data")) {
//            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//            MultipartFile file = multipartRequest.getFile("file"); // 假设你的文件字段名为"file"
//            if (file != null && file.getSize() > MAX_FILE_SIZE) {
//                // 文件大小超过限制
//                // 这里可以设置响应状态码和消息，或者跳转到错误页面
//                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                response.getWriter().write("File size exceeds the maximum limit of 5mb.");
//                return false; // 返回false中断请求
//            }
//        }
//        return true; // 返回true继续流程
//        if ("POST".equalsIgnoreCase(request.getMethod()) && request instanceof MultipartHttpServletRequest) {
//            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//            MultipartFile file = multipartRequest.getFile("file"); // 假设你的文件字段名为"file"
//            if (file != null) {
//                try (InputStream inputStream = file.getInputStream()) {
//                    BufferedImage image = ImageIO.read(inputStream);
//                    if (image != null) {
//                        int width = image.getWidth();
//                        int height = image.getHeight();
//                        if (width > MAX_WIDTH || height > MAX_HEIGHT) {
//                            // 图片尺寸超过限制
//                            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                            response.getWriter().write("Image size exceeds the maximum limit.");
//                            return false; // 返回false中断请求
//                        }
//                    }
//                } catch (IOException e) {
//                    // 处理异常，可能是文件不是图片或者读取错误
//                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                    response.getWriter().write("Failed to read the image file.");
//                    return false;
//                }
//            }
//        }
//        return true; // 返回true继续流程
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file"); // 假设你的文件字段名为"file"
        File file1=multipartFile2File(file);
        ImgUtil.pressText(//
                FileUtil.file(file1), //
                FileUtil.file("C:/ok","ok1.jpg"), //
                "版权所有", Color.WHITE, //文字
                new Font("黑体", Font.BOLD, 100), //字体
                0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
        );

        String path = request.getRequestURI();
        String clientIp = request.getRemoteAddr();
        log.info("请求到拦截器，path:{},clientIp{}",path,clientIp);
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("拦截器处理之后，时间time:{},path:{}", LocalDateTime.now(),request.getRequestURI());
    }
    public File multipartFile2File(MultipartFile multipartFile) {
        String path = "D:\\text.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            // 底层也是通过io流写入文件file
            FileCopyUtils.copy(multipartFile.getBytes(), file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return file;
    }


}
