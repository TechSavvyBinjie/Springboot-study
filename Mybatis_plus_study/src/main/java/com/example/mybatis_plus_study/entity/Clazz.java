package com.example.mybatis_plus_study.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class Clazz {
    private Long id;
    private String name;
    private Long teacherId;
    // ⽤于⼀对⼀映射
    @TableField(exist = false)
    private Teacher teacher;

    @TableField(exist = false)
    private List<Student> students;
}
