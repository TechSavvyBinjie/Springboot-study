package com.jpa_study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Teacher {
    private  Integer teacherId;
    private  String teacherName;
    private  Integer clazzId;
    private Clazz clazz;
}
