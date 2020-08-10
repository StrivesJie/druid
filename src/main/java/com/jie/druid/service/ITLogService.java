package com.jie.druid.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jie.common.base.Constants;
import com.jie.druid.entity.QueryRequest;
import com.jie.druid.entity.SystemLog;
import com.jie.druid.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import java.lang.reflect.Method;

/**
 * <p>
 * 操作日志表 服务类
 * </p>
 *
 * @author wsj
 * @since 2020-08-07
 */
public interface ITLogService extends IService<SystemLog> {
    /**
     * 查询操作日志分页
     *
     * @param systemLog 日志
     * @param request   QueryRequest
     * @return IPage<SystemLog>
     */
    IPage<SystemLog> findLogs(SystemLog systemLog, QueryRequest request);

    /**
     * 删除操作日志
     *
     * @param logIds 日志 ID集合
     */
    void deleteLogs(String[] logIds);

    /**
     * 异步保存操作日志
     *
     * @param user      用户信息
     * @param point     切点
     * @param method    Method
     * @param ip   ip
     * @param operation 操作内容
     * @param start     开始时间
     */
    @Async(Constants.ASYNC_POOL)
    void saveLog(User user, ProceedingJoinPoint point, Method method, String ip, String operation, long start);

}
