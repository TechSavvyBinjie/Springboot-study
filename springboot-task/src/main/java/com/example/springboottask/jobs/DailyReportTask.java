package com.example.springboottask.jobs;

import com.example.springboottask.Service.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DailyReportTask {
    private final MailService mailService;

//    @Scheduled(fixedRate = 10000)
//    public void sendReport(){
//        String report="则是每日数据报表";
//        mailService.sendMail("2309932069@qq.com","测试",report);
//        log.info("报表已经生成{}",new Date());
//
//    }
}
