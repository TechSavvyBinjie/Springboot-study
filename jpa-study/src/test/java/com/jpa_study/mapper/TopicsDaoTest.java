package com.jpa_study.mapper;

import com.jpa_study.entity.Topics;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TopicsDaoTest {
@Resource
private TopicsDao topicsDao;
    @Test
    void findAll() {
    List<Topics> topics=topicsDao.findAll();
    }
}