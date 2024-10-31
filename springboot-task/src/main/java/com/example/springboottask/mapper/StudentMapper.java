package com.example.springboottask.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboottask.entity.student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<student> {
}
