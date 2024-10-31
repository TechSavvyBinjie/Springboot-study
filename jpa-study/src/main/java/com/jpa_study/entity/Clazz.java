package com.jpa_study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer clazzId;
    private  String clazzName;
    private  Integer teacherId;
    private  Teacher teacher;
    private List<student> students;
}
