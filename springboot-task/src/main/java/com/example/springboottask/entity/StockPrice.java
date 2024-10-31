package com.example.springboottask.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@TableName("stock_price")
public class StockPrice {
    private Integer id;
    private String Name;
    private Date UpdateTime;
    private Double price;
}
