package com.jie.druid.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class TaskTwoJob implements Job {

    public TaskTwoJob() {

    }
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("任务二-----------执行中");
    }
}
