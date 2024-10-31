package com.example.mybatis_plus_study.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_plus_study.entity.Clazz;
import com.example.mybatis_plus_study.entity.Student;
import com.example.mybatis_plus_study.entity.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClazzMapper extends BaseMapper<Clazz> {
    @Select("SELECT * FROM teacher WHERE id = #{teacherId}")
    Teacher selectTeacherByClazzId(Long teacherId);

    @Select("SELECT * FROM student WHERE clazz_id = #{clazzId}")
    List<Student> selectStudentByClazzId(Long clazzId);
}
