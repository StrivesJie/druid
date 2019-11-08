package com.jie.druid.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jie.druid.entity.BmsCloudInvoice;
import com.jie.druid.mapper.BmsCloudInvoiceDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 平台发票管理表 前端控制器
 * </p>
 *
 * @author wsj
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/bms-cloud-invoice")
public class BmsCloudInvoiceController {
    @Resource
    private BmsCloudInvoiceDao invoiceDao;

    @GetMapping("/sel")
    public String lambdaPagination() {
        Page<BmsCloudInvoice> page = new Page<>(1, 5);
        QueryWrapper<BmsCloudInvoice> wrapper = new QueryWrapper<>();
        wrapper.lambda().ge(BmsCloudInvoice::getCompanyid, 666).orderByAsc(BmsCloudInvoice::getCredate);
        IPage<BmsCloudInvoice> result = invoiceDao.selectPage(page, wrapper);
        System.out.println(result.getTotal());
        return result.getRecords().toString();
    }
}
