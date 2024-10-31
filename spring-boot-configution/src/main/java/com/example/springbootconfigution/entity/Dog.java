package com.example.springbootconfigution.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "student.dog")
public class Dog {
    private String name;
    private int age;
}
