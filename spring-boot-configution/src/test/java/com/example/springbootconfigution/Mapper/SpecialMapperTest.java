package com.example.springbootconfigution.Mapper;

import com.example.springbootconfigution.entity.Special;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class SpecialMapperTest {
@Resource
private SpecialMapper specialMapper;
    @Test
    void findAll() {
        List<Special> all=specialMapper.findAll();
        all.forEach(System.out::println);
    }
}