package com.jie.druid.config;

import com.jie.druid.enums.DataSourceEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wangsj
 * @date ：Created in 2019/11/7
 * @description：
 * @modified By：
 */
public class DynamicDataSourceContextHolder {
    private static ThreadLocal<Object> CONTEXT_HOLDER = ThreadLocal.withInitial(() -> DataSourceEnum.MASTER.getValue());

    public static List<Object> dataSourceKeys = new ArrayList<Object>();

    public static void setDataSourceKey(String key){
        CONTEXT_HOLDER.set(key);
    }

    public static Object getDataSourceKey(){
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceKey(){
        CONTEXT_HOLDER.remove();
    }

    public static Boolean containDataSourceKey(String key){
        return dataSourceKeys.contains(key);
    }

}
