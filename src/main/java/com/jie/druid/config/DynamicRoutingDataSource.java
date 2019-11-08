package com.jie.druid.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author ：wangsj
 * @date ：Created in 2019/11/7
 * @description：扩展Spring的AbstractRoutingDataSource抽象类，实现动态数据源。
 * AbstractRoutingDataSource中的抽象方法determineCurrentLookupKey是实现数据源的route的核心，
 * 这里对该方法进行Override。 【上下文DbContextHolder为一线程安全的ThreadLocal】
 * @modified By：
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("current datasource is : {}",DynamicDataSourceContextHolder.getDataSourceKey());
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }

}
