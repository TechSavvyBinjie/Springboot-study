package com.jpa_study.mapper;

import com.jpa_study.entity.Topics;

import java.util.List;

public interface TopicsDao {
  List<Topics> findAll();
}