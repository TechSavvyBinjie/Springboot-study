package com.jpa_study.mapper;

import com.jpa_study.entity.Clazz;

public interface ClazzMapper {
    Clazz getClazzById(int clazzId);
    Clazz getClazz(int clazzId);
}
