package com.jie.druid.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：wangsj
 * @date ：Created in 2020/5/11
 * @description：
 * @modified By：
 */
@Data
@Accessors(chain = true)
public class Mingjue {

    private String registno;
    private String querytime;
    private String vincode;
    private String reqpartname;
    private String reqpartno;
    private String reqpartprice;
    private String standardpartno;
    private String standardprice;
    private String handlercode;
    private String handlername;
    private String repairfactoryname;

}
