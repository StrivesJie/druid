package com.jie.druid.mapper;

import com.jie.druid.entity.JobDetailInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：wangsj
 * @date ：Created in 2020/5/18
 * @description： 获取所有数据库的定时任务集合
 * @modified By：
 */
@Mapper
public interface JobDetailInfoMapper {

    public List<JobDetailInfo> getJobDetailInfo();
}
