package com.jie.druid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jie.druid.entity.LoginLog;
import com.jie.druid.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 登录日志表 Mapper 接口
 * </p>
 *
 * @author wsj
 * @since 2020-08-07
 */
public interface TLoginLogDao extends BaseMapper<LoginLog> {
    /**
     * 获取系统总访问次数
     *
     * @return Long
     */
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     *
     * @return Long
     */
    Long findTodayVisitCount();

    /**
     * 获取系统今日访问 IP数
     *
     * @return Long
     */
    Long findTodayIp();

    /**
     * 获取系统近七天来的访问记录
     *
     * @param user 用户
     * @return 系统近七天来的访问记录
     */
    List<Map<String, Object>> findLastSevenDaysVisitCount(User user);
}