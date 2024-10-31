package com.example.mybatis_plus_study.Service;

import com.example.mybatis_plus_study.Mapper.StudentCourseMapper;
import com.example.mybatis_plus_study.Mapper.StudentMapper;
import com.example.mybatis_plus_study.entity.Course;
import com.example.mybatis_plus_study.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentCourseMapper studentCourseMapper;
    /**
     * 根据学⽣ID获取该学⽣的课程信息
     */
    public Student getStudentWithCourses(Long studentId) {
        Student student = studentMapper.selectById(studentId);
        if (student != null) {
            List<Course> courses = studentCourseMapper.selectCoursesByStudentId(studentId);
            student.setCourses(courses);
        }
        return student;
    }
}
