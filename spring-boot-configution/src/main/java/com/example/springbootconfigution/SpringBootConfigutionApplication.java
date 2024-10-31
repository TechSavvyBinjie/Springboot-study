package com.example.springbootconfigution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource( locations = {"classpath:beans.xml"})
public class SpringBootConfigutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigutionApplication.class, args);
    }

}
