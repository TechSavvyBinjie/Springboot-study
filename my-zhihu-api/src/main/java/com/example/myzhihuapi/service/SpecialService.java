package com.example.myzhihuapi.service;

import com.example.myzhihuapi.entity.Special;

import java.util.List;

public interface SpecialService {
    List<Special> getAll();
    List<Special> getByPage(int limit,int offset);

}
