package com.jie.druid.service;

import com.jie.druid.entity.Mingjue;

import java.util.List;

public interface IMingjueService {
    List<Mingjue> findMingjueList(String standardpartno,
                                  String reqpartno,
                                  String businessno);
}
