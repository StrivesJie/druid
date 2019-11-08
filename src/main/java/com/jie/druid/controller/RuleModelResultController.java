package com.jie.druid.controller;


import com.alibaba.fastjson.JSONObject;
import com.jie.druid.annotation.TargetDataSource;
import com.jie.druid.entity.RuleModelResult;
import com.jie.druid.enums.DataSourceEnum;
import com.jie.druid.service.IRuleModelResultService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wsj
 * @since 2019-11-07
 */
@RestController
public class RuleModelResultController {

    @Autowired
    private IRuleModelResultService resultService;

    @GetMapping("/user")
    @TargetDataSource(DataSourceEnum.SLAVE)
    public ResponseEntity<Object> listAll(){

        List<RuleModelResult> list = resultService.list();
        return ResponseEntity.ok(list);

    }

}
