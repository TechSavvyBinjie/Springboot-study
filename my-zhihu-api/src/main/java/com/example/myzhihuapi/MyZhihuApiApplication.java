package com.example.myzhihuapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.myzhihuapi.mapper"})
public class MyZhihuApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyZhihuApiApplication.class, args);
    }

}
