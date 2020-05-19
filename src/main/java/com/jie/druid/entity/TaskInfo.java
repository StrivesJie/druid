package com.jie.druid.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel("定时任务VO类")
public class TaskInfo implements Serializable{
    private static final long serialVersionUID = 1L;


    /**任务名称*/
    @ApiModelProperty(value="任务全类名",example="com.jie.druid.job.TaskOneJob")
    private String jobName;

    /**任务分组*/
    @ApiModelProperty(value="组名",example="显示任务")
    private String jobGroup;

    /**任务描述*/
    @ApiModelProperty(value="描述",example="任务功能")
    private String jobDescription;

    /**任务状态*/
    private String jobStatus;

    /**任务表达式*/
    @ApiModelProperty(value="任务表达式",example="*/30 * * * * ?")
    private String cronExpression;

    private String createTime;


}
