package com.example.springboottask.jobs;

import com.example.springboottask.mapper.StockPriceMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
@Slf4j
public class StockPriceTask {
    private final StockPriceMapper stockPriceMapper;

    private final Random random = new Random();

//    @Scheduled(fixedRate = 10000)
//    public void updatedStockPrice(){
//        double price = 100+random.nextDouble()*50;
//        StockPrice stockPrice=new StockPrice();
//        DecimalFormat decimalFormat=new DecimalFormat(".00");
//        stockPrice.setPrice(Double.parseDouble(decimalFormat.format(price)));
//        stockPrice.setName("小米");
//        stockPrice.setUpdateTime(new Date());
//        stockPriceMapper.insert(stockPrice);
//        log.info("插入成功");
//    }
}
