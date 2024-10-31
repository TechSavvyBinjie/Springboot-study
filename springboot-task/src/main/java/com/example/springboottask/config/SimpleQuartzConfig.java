package com.example.springboottask.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author 孙欣慰
 */
@Configuration
public class SimpleQuartzConfig {
//    @Bean
//    public JobDetail jobDetail() {
//        return JobBuilder.newJob(SimpleQuartzTask.class)
//                .withIdentity("simpleQuartzTask")
//                .storeDurably()
//                .build();
//    }
//    @Bean
//    public Trigger trigger() {
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
//
//        return TriggerBuilder.newTrigger().forJob(jobDetail())
//                .withIdentity("simpleQuartzTask")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
}
