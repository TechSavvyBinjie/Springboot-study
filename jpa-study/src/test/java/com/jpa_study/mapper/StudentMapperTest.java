package com.jpa_study.mapper;

import com.jpa_study.entity.Clazz;
import com.jpa_study.entity.Course;
import com.jpa_study.entity.student;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class StudentMapperTest {
 @Resource

 private StudentMapper studentMapper;
    @Test
    void getStudentManyToOne() {
        student student=studentMapper.getStudent(1001);
        log.info("{},{},{}",student.getStudentId(),student.getStudentName());
        List<Course> courses=student.getCourses();
        Clazz clazz=student.getClazz();
        log.info(clazz.getClazzName());
        courses.forEach(course -> log.info("{},{}",course.getCourseId(),course.getCourseName()));
    }
}