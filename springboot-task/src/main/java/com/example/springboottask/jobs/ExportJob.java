package com.example.springboottask.jobs;

import com.alibaba.excel.EasyExcel;
import com.example.springboottask.entity.student;
import com.example.springboottask.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
public class ExportJob extends QuartzJobBean {
    private final StudentMapper studentMapper;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("开始执行到处任务！");
        List<student> students =studentMapper.selectList(null);
        String fileName = "C:/ok/"+ UUID.randomUUID()+".xls";
        EasyExcel.write(fileName,student.class).sheet("学生数据").doWrite(() -> students);
    }
}
