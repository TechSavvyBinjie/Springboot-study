package com.example.springbootconfigution.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class familyTest {
     @Resource
     private family family;
     @Test
    void test(){
         System.out.println(family);
     }
}