package com.example.springbootconfigution.Mapper;

import com.example.springbootconfigution.entity.Special;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SpecialMapper {
    @Select("SELECT * FROM list ORDER BY updated DESC")
    List<Special> findAll();
}
