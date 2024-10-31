package com.jpa_study.mapper;

import com.jpa_study.entity.Course;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
@Slf4j
class CourseMapperTest {
@Resource
CourseMapper courseMapper;
    @Test
    void getCourse() {
        List<Course> course = courseMapper.getCourse();
//        List<student> students=course.getStudents();
//        log.info(course.getCourseName());
//        students.forEach(student -> log.info("{},{},{}",student.getStudentId(),student.getStudentName(),student.getHometown()));
    }
}