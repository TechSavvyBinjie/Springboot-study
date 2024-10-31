package com.jpa_study.mapper;

import com.jpa_study.entity.student;

public interface StudentMapper {
    student getStudentManyToOne(int studentId);
    student getStudent(int studentId);
}
