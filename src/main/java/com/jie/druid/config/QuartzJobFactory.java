package com.jie.druid.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author ：wangsj
 * @date ：Created in 2020/5/18
 * @description：动态任务配置类
 * @modified By：
 */
@Component
public class QuartzJobFactory extends AdaptableJobFactory {


    //这个对象交给Spring自动注入
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;


    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        // 调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        // 进行注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }

}
