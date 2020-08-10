package com.jie.druid.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wangsj
 * @date ：Created in 2019/11/6 16:13
 * @description：数据源配置
 * @modified By：
 */
@Configuration
public class DruidConfig {

    /**
     * 配置指定
     * 如果maven已经引入jpa则不需要加上初始化以及销毁方法，如果使用的是mybatis并且没有引入jpa，则
     * 需要加上(destroyMethod = "close", initMethod = "init")
     * @return datasource
     */
    /*@Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.druid.datasource")
    public DruidDataSource druid() {
        return new DruidDataSource();
    }*/







    //配置Druid的监控
    //1. 配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean =  new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<>();

        initParams.put("loginUsername","admin");//账号
        initParams.put("loginPassword","admin");//密码
        initParams.put("allow","");//默认允许所有
        initParams.put("deny","192.168.123.22");//不允许的黑名单ip

        bean.setInitParameters(initParams);
        return bean;
    }

    // 2. 配置一个监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        //忽略资源
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");

        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
