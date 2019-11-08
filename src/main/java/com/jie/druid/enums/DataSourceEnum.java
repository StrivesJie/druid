package com.jie.druid.enums;

/**
 * @author ：wangsj
 * @date ：Created in 2019/11/7
 * @description： 多数据源
 * @modified By：
 */
public enum  DataSourceEnum {
    //主数据源（默认）
    MASTER("master"),
    //从数据源
    SLAVE("slave");

    private String value;

    DataSourceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
