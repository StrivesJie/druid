package com.jie.druid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jie.common.base.Constants;
import com.jie.common.utils.AddressUtil;
import com.jie.common.utils.HttpContextUtil;
import com.jie.common.utils.IpInfoUtils;
import com.jie.common.utils.SortUtil;
import com.jie.druid.entity.LoginLog;
import com.jie.druid.entity.QueryRequest;
import com.jie.druid.entity.User;
import com.jie.druid.mapper.TLoginLogDao;
import com.jie.druid.service.ITLoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 登录日志表 服务实现类
 * </p>
 *
 * @author wsj
 * @since 2020-08-07
 */
@Service
public class TLoginLogServiceImpl extends ServiceImpl<TLoginLogDao, LoginLog> implements ITLoginLogService {
    @Override
    public IPage<LoginLog> findLoginLogs(LoginLog loginLog, QueryRequest request) {
        QueryWrapper<LoginLog> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(loginLog.getLoginTimeFrom()) &&
                StringUtils.equals(loginLog.getLoginTimeFrom(), loginLog.getLoginTimeTo())) {
            loginLog.setLoginTimeFrom(loginLog.getLoginTimeFrom() + " 00:00:00");
            loginLog.setLoginTimeTo(loginLog.getLoginTimeTo() + " 23:59:59");
        }
        if (StringUtils.isNotBlank(loginLog.getUsername())) {
            queryWrapper.lambda().eq(LoginLog::getUsername, loginLog.getUsername().toLowerCase());
        }
        if (StringUtils.isNotBlank(loginLog.getLoginTimeFrom()) && StringUtils.isNotBlank(loginLog.getLoginTimeTo())) {
            queryWrapper.lambda()
                    .ge(LoginLog::getLoginTime, loginLog.getLoginTimeFrom())
                    .le(LoginLog::getLoginTime, loginLog.getLoginTimeTo());
        }

        Page<LoginLog> page = new Page<>(request.getPageNum(), request.getPageSize());
        SortUtil.handlePageSort(request, page, "loginTime", Constants.ORDER_DESC, true);

        return this.page(page, queryWrapper);
    }

    @Override
    public void saveLoginLog(LoginLog loginLog) {
        loginLog.setLoginTime(LocalDateTime.now());
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IpInfoUtils.getIpAddr(request);
        loginLog.setIp(ip);
        loginLog.setLocation(AddressUtil.getCityInfo(ip));
        this.save(loginLog);
    }

    @Override
    public void deleteLoginLogs(String[] ids) {
        List<String> list = Arrays.asList(ids);
        baseMapper.deleteBatchIds(list);
    }

    @Override
    public Long findTotalVisitCount() {
        return this.baseMapper.findTotalVisitCount();
    }

    @Override
    public Long findTodayVisitCount() {
        return this.baseMapper.findTodayVisitCount();
    }

    @Override
    public Long findTodayIp() {
        return this.baseMapper.findTodayIp();
    }

    @Override
    public List<Map<String, Object>> findLastSevenDaysVisitCount(User user) {
        return this.baseMapper.findLastSevenDaysVisitCount(user);
    }
}
