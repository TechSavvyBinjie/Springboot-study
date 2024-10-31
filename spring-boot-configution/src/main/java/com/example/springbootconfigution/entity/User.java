package com.example.springbootconfigution.entity;

import jakarta.annotation.Resource;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class User {
 @NotNull
 @Size(min = 3,max=20)
    private String username;

 @NotBlank
    private String password;

 @Email
 private String email;

 @Min(18)
    @Max(100)
    private int age;

 @Pattern(regexp = "^[0-9]{11}$")
    private String phoneNumber;

 @Future
    private LocalDate subscriptionEndDate;

 @Positive
    private int score;

 @URL
    private String website;
}
