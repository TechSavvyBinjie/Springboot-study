package com.example.mybatis_plus_study.Controller;

import com.example.mybatis_plus_study.Service.ClazzService;
import com.example.mybatis_plus_study.entity.Clazz;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clazz")
@AllArgsConstructor
public class ClazzController {
    private final ClazzService clazzService;
    /**
     * 获取班级和对应⽼师信息
     */
    @GetMapping("/{id}")
    public Clazz getClazzWithTeacher(@PathVariable Long id) {
        return clazzService.getClazzWithTeacher(id);
    }
    @GetMapping("/students/{id}")
    public Clazz getClazzWithStudent(@PathVariable Long id) {
        return clazzService.getClazzWithStudent(id);
    }
}