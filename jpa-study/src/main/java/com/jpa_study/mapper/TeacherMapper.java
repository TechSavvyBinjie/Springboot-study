package com.jpa_study.mapper;

import com.jpa_study.entity.Teacher;

public interface TeacherMapper {
    Teacher findTeacherById(Integer teacherId);
}
