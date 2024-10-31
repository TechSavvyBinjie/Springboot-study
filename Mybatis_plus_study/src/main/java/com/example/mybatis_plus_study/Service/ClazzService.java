package com.example.mybatis_plus_study.Service;

import com.example.mybatis_plus_study.Mapper.ClazzMapper;
import com.example.mybatis_plus_study.entity.Clazz;
import com.example.mybatis_plus_study.entity.Student;
import com.example.mybatis_plus_study.entity.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;
    /**
     * 根据班级ID获取班级和对应⽼师
     */
    public Clazz getClazzWithTeacher(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
            clazz.setTeacher(teacher);
        }
        return clazz;
    }
    public Clazz getClazzWithStudent(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            List<Student> students= clazzMapper.selectStudentByClazzId(clazzId);
            clazz.setStudents(students);
        }
        return clazz;
    }
}
