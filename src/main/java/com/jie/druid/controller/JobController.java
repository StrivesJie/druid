package com.jie.druid.controller;

import com.github.pagehelper.PageInfo;
import com.jie.druid.annotation.TargetDataSource;
import com.jie.druid.common.Result;
import com.jie.druid.entity.JobDetailInfo;
import com.jie.druid.entity.TaskInfo;
import com.jie.druid.enums.DataSourceEnum;
import com.jie.druid.service.ITaskService;
import com.jie.druid.service.impl.JobDetailInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 */
@Api("增删查改定时任务")
@RestController
@RequestMapping(value = "job")
@TargetDataSource(DataSourceEnum.SLAVE)
public class JobController {

	private static final Logger logger = LogManager.getLogger(JobController.class);

	@Autowired
	private JobDetailInfoService jobDetailInfoService;

	@Autowired
	private ITaskService taskQuartzService;
	
	/**
	 * 新增任务
	 * @param taskInfoVo
	 * @throws Exception
	 */
	@ApiOperation("增加定时任务")
	@ApiImplicitParam(name="addjob",dataTypeClass=TaskInfo.class)
	@GetMapping(value = "/addjob")
	public Result addjob(TaskInfo taskInfoVo) {
		logger.info("新增Quartz定时任务");
		boolean flag = taskQuartzService.addJob(taskInfoVo);
		return Result.result(flag, "处理完毕", taskInfoVo);
	}
	
	/**
	 * 暂停任务
	 * @param taskInfoVo
	 * @throws Exception
	 */
	@ApiOperation("暂停定时任务")
	@ApiImplicitParam(name="pausejob",dataTypeClass=TaskInfo.class)
	@GetMapping(value = "/pausejob")
	public Result pausejob(TaskInfo taskInfoVo) {
		logger.info("暂停Quartz定时任务");
		boolean flag=taskQuartzService.pause(taskInfoVo.getJobName(), taskInfoVo.getJobGroup());
		return Result.result(flag, "处理完毕", taskInfoVo);
	}

	/**
	 * 恢复某个任务
	 * @param taskInfoVo
	 * @throws Exception
	 */
	@ApiOperation("恢复某个任务")
	@ApiImplicitParam(name="resumejob",dataTypeClass=TaskInfo.class)
	@GetMapping(value = "/resumejob")
	public Result resumejob(TaskInfo taskInfoVo) throws Exception {
		logger.info("恢复Quartz定时任务");
		boolean flag=taskQuartzService.resume(taskInfoVo.getJobName(), taskInfoVo.getJobGroup());
		return Result.result(flag, "处理完毕", taskInfoVo);
	}

	/**
	 * 恢复所有任务
	 * @throws Exception
	 */
	@ApiOperation("恢复所有任务")
	@GetMapping(value = "/resumealljob")
	public Result resumealljob() {
		logger.info("恢复Quartz所有定时任务");
		boolean flag=taskQuartzService.resumeAllJob();
		return Result.result(flag, "处理完毕", null);
	}
	
	/**
	 * 删除任务
	 * @param taskInfoVo
	 * @throws Exception
	 */
	@ApiOperation("删除任务")
	@ApiImplicitParam(name="deletejob",dataTypeClass=TaskInfo.class)
	@PostMapping(value = "/deletejob")
	public Result deletejob(TaskInfo taskInfoVo) throws Exception {
		logger.info("删除Quartz定时任务");
		boolean flag=taskQuartzService.delete(taskInfoVo.getJobName(), taskInfoVo.getJobGroup());
		return Result.result(flag, "处理完毕", taskInfoVo);
	}

	/**
	 * 更新任务
	 * @param taskInfoVo
	 * @throws Exception
	 */
	@ApiOperation("更新任务")
	@ApiImplicitParam(name="updatejob",dataTypeClass= TaskInfo.class)
	@PostMapping(value = "/updatejob")
	public Result rescheduleJob(TaskInfo taskInfoVo) throws Exception {
		logger.info("更新Quartz定时任务");
		boolean flag=taskQuartzService.edit(taskInfoVo);
		return Result.result(flag, "处理完毕", taskInfoVo);
	}

	/**
	 * 查找库表中的定时任务
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ApiOperation("分页查找库表中的定时任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNumber",value="页码",required=true,dataTypeClass=Integer.class),
		@ApiImplicitParam(name="pageSize",value="每页数量",required=true,dataTypeClass=Integer.class)
	})
	@GetMapping(value = "/queryjob")
	public Result queryjob(@RequestParam(defaultValue="1") Integer pageNumber, @RequestParam(defaultValue="5") Integer pageSize) {
		PageInfo<JobDetailInfo> jobDetailInfo = jobDetailInfoService.getJobDetailInfo(pageNumber, pageSize);
		return Result.success(jobDetailInfo);
	}
}