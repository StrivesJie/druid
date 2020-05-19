package com.jie.druid.mapper;

import com.jie.druid.entity.Mingjue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MingjueDao {
    List<Mingjue> findMingjueList(@Param("standardpartno") String standardpartno,
                                  @Param("reqpartno") String reqpartno,
                                  @Param("businessno") String businessno);
}
