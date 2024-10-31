package com.jpa_study.mapper;

import com.jpa_study.entity.Clazz;
import com.jpa_study.entity.Teacher;
import com.jpa_study.entity.student;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
@Slf4j

class ClazzMapperTest {
    @Resource
    private ClazzMapper clazzMapper;

    @Test
    void getClazzById() {
        Clazz clazz = clazzMapper.getClazz(1);
        log.info("{},{}",clazz.getClazzId(),clazz.getClazzName());
        List<student> students=clazz.getStudents();
        Teacher teacher=clazz.getTeacher();
        students.forEach(student -> log.info("{},{},{}",student.getStudentId(),student.getStudentName(),student.getHometown()));
        log.info("{}",teacher.getTeacherName());
    }
}