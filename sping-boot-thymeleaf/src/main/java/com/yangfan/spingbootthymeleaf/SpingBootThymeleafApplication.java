package com.yangfan.spingbootthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpingBootThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingBootThymeleafApplication.class, args);
    }
    @GetMapping
    public String hello(String name){
        return "hello1"+name;
    }
}
