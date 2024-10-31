package com.example.springbootconfigution;

import com.example.springbootconfigution.entity.student;
import com.example.springbootconfigution.entity.person;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootConfigutionApplicationTests {
    @Resource
    private student student;
    @Test
    void contextLoads() {
        System.out.println(student);
    }

}
