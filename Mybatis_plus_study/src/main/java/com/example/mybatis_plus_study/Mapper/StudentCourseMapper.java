package com.example.mybatis_plus_study.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_plus_study.entity.Course;
import com.example.mybatis_plus_study.entity.StudentCourse;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    @Select("SELECT c.* FROM course c INNER JOIN student_course sc ON c.id = sc.course_id WHERE sc.student_id = #{studentId}")
    List<Course> selectCoursesByStudentId(Long studentId);
}
