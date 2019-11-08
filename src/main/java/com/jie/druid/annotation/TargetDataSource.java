package com.jie.druid.annotation;

import com.jie.druid.enums.DataSourceEnum;

import java.lang.annotation.*;

/**
 * 自定义注解，默认使用master数据源
 * @author jie
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    DataSourceEnum value() default DataSourceEnum.MASTER;
}
