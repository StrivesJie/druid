package com.jie.druid.entity;

import lombok.Data;

/**
 * @author ：wangsj
 * @date ：Created in 2020/5/18
 * @description：
 * @modified By：
 */
@Data
public class JobDetailInfo {

        private String JOB_NAME;
        private String JOB_GROUP;
        private String JOB_CLASS_NAME;
        private String TRIGGER_NAME;
        private String TRIGGER_GROUP;
        private String DESCRIPTION;
        private String CRON_EXPRESSION;
        private String TIME_ZONE_ID;
}
