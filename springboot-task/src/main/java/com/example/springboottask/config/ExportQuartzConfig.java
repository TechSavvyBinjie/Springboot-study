package com.example.springboottask.config;

import com.example.springboottask.jobs.ExportJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExportQuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(ExportJob.class)
                .withIdentity("Task1")
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger trigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("Task1")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
