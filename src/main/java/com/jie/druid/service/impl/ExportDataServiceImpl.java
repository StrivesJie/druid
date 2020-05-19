package com.jie.druid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jie.druid.entity.ExportData;
import com.jie.druid.mapper.ExportDataDao;
import com.jie.druid.service.IExportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wsj
 * @since 2020-05-12
 */
@Service
public class ExportDataServiceImpl extends ServiceImpl<ExportDataDao, ExportData> implements IExportDataService {
    @Autowired
    private ExportDataDao exportDataDao;

    @Override
    public List<ExportData> findMingjueList(String standardpartno, String reqpartno, String businessno) {
        return exportDataDao.findMingjueList1(standardpartno, reqpartno, businessno);
    }
}
