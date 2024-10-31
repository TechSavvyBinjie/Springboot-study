package com.example.springbootconfigution.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "person")
public class person {
    private String firstName;
    private String lastName;
    private int age;
    private String id;
    private String phone;
}
