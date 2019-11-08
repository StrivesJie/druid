package com.jie.druid;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jie.druid.entity.BmsCloudInvoice;
import com.jie.druid.mapper.BmsCloudInvoiceDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidApplicationTests {

    @Resource
    private BmsCloudInvoiceDao invoiceDao;
    @Test
    public void contextLoads() {
    }
    @Test
    public void lambdaPagination() {
        Page<BmsCloudInvoice> page = new Page<>(1, 5);
        QueryWrapper<BmsCloudInvoice> wrapper = new QueryWrapper<>();
        wrapper.lambda().ge(BmsCloudInvoice::getCompanyid, 666).orderByAsc(BmsCloudInvoice::getCredate);
        IPage<BmsCloudInvoice> result = invoiceDao.selectPage(page, wrapper);
        System.out.println(result.getTotal());
        Assert.assertTrue(result.getTotal() > 3);
        Assert.assertEquals(5, result.getRecords().size());
    }

}
