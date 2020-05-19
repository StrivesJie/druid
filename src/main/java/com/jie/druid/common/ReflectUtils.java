package com.jie.druid.common;

import org.quartz.Job;

/**
 * @author ：wangsj
 * @date ：Created in 2020/5/18
 * @description：
 * @modified By：
 */
public class ReflectUtils {
    public static Job getObjectByClass(String classname) throws Exception {
        Class<?> clazz = Class.forName(classname);
        return (Job) clazz.newInstance();
    }
}
