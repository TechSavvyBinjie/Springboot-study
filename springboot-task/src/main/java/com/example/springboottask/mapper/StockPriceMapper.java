package com.example.springboottask.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboottask.entity.StockPrice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockPriceMapper extends BaseMapper<StockPrice> {
}
