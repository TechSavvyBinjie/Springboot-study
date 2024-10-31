package com.example.myzhihuapi.mapper;

import com.example.myzhihuapi.entity.Special;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SpecialMapperTest {
@Resource
private SpecialMapper specialMapper;
    @Test
    void selectByPage() {
        List<Special> specials=specialMapper.selectByPage(2,0);
        specials.forEach(System.out::println);
    }
}