package com.jie.druid.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class TaskOneJob implements Job {

    public TaskOneJob() {

    }
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("任务一-----------执行中");
        log.info("小春子是傻逼");
        log.info("任务一-----------执行结束");
    }
}
