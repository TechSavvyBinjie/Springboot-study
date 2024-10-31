package com.example.myzhihuapi.mapper;

import com.example.myzhihuapi.entity.Special;

import java.util.List;

public interface SpecialMapper {
    List<Special> selectAll();
    List<Special> selectByPage(int limit,int offset);
}
