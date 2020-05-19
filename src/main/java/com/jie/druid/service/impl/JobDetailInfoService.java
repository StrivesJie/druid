package com.jie.druid.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jie.druid.entity.JobDetailInfo;
import com.jie.druid.mapper.JobDetailInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：wangsj
 * @date ：Created in 2020/5/18
 * @description：
 * @modified By：
 */
@Service
public class JobDetailInfoService {

    @Autowired
    private JobDetailInfoMapper jobDetailInfoMapper;

    public PageInfo<JobDetailInfo> getJobDetailInfo(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<JobDetailInfo> list = jobDetailInfoMapper.getJobDetailInfo();
        PageInfo<JobDetailInfo> page = new PageInfo<JobDetailInfo>(list);
        return page;
    }
}
