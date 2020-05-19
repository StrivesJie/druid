package com.jie.druid.service;

import com.jie.druid.entity.TaskInfo;
import org.quartz.SchedulerException;

import java.util.List;

public interface ITaskService {

    List<TaskInfo> list();

    boolean addJob(TaskInfo info);

    boolean edit(TaskInfo info);

    boolean delete(String jobName, String jobGroup);

    boolean pause(String jobName, String jobGroup);

    boolean resume(String jobName, String jobGroup);

    boolean resumeAllJob();

    boolean checkExists(String jobName, String jobGroup)throws SchedulerException;

}