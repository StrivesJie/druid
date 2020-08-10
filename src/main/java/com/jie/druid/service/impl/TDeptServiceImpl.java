package com.jie.druid.service.impl;

import com.jie.druid.entity.Dept;
import com.jie.druid.mapper.TDeptDao;
import com.jie.druid.service.ITDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author wsj
 * @since 2020-08-06
 */
@Service
public class TDeptServiceImpl extends ServiceImpl<TDeptDao, Dept> implements ITDeptService {

}
