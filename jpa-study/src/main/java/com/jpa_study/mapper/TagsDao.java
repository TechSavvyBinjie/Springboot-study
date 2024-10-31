package com.jpa_study.mapper;

import com.jpa_study.entity.Tags;

public interface TagsDao {
    int deleteByPrimaryKey(Long sectionId);

    int insert(Tags record);

    int insertSelective(Tags record);

    Tags selectByPrimaryKey(Long sectionId);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);
}