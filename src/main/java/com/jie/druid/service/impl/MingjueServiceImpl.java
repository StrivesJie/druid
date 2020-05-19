package com.jie.druid.service.impl;

import com.jie.druid.entity.Mingjue;
import com.jie.druid.mapper.MingjueDao;
import com.jie.druid.service.IMingjueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：wangsj
 * @date ：Created in 2020/5/11
 * @description：
 * @modified By：
 */
@Service
public class MingjueServiceImpl implements IMingjueService {

    @Autowired
    private MingjueDao mingjueDao;
    @Override
    public List<Mingjue> findMingjueList(String standardpartno, String reqpartno, String businessno) {
        return mingjueDao.findMingjueList(standardpartno, reqpartno, businessno);
    }
}
