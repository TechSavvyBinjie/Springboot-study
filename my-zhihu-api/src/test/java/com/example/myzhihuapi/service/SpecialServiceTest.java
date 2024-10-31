package com.example.myzhihuapi.service;

import com.example.myzhihuapi.entity.Special;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SpecialServiceTest {
@Resource
 private SpecialService specialService;
    @Test
    void getAll() {
        List<Special> specials=specialService.getAll();
        specials.forEach(System.out::println);
    }
}