package com.jie.druid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jie.druid.entity.ExportData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wsj
 * @since 2020-05-12
 */
public interface ExportDataDao extends BaseMapper<ExportData> {

    List<ExportData> findMingjueList1(@Param("standardpartno")String standardpartno,
                                     @Param("reqpartno")String reqpartno,
                                     @Param("businessno")String businessno);
}
