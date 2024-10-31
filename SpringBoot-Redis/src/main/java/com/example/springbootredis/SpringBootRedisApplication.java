package com.example.springbootredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = {"com.example.springbootredis.mapper"})
@SpringBootApplication
public class SpringBootRedisApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootRedisApplication.class, args);
    }

}
