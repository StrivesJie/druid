package com.jie.druid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jie.druid.entity.ExportData;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wsj
 * @since 2020-05-12
 */
public interface IExportDataService extends IService<ExportData> {
    List<ExportData> findMingjueList(String standardpartno,
                                     String reqpartno,
                                     String businessno);
}
