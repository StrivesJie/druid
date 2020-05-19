package com.jie.druid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wsj
 * @since 2020-05-12
 */
public class ExportData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String registno;

    private LocalDateTime querytime;

    private String vincode;

    private String reqpartname;

    private String reqpartno;

    private String reqpartprice;

    private String standardpartno;

    private String standardprice;

    private String istrue;

    private String handlercode;

    private String handlername;

    private String repairfactoryname;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public String getRegistno() {
        return registno;
    }

    public void setRegistno(String registno) {
        this.registno = registno;
    }
    public LocalDateTime getQuerytime() {
        return querytime;
    }

    public void setQuerytime(LocalDateTime querytime) {
        this.querytime = querytime;
    }
    public String getVincode() {
        return vincode;
    }

    public void setVincode(String vincode) {
        this.vincode = vincode;
    }
    public String getReqpartname() {
        return reqpartname;
    }

    public void setReqpartname(String reqpartname) {
        this.reqpartname = reqpartname;
    }
    public String getReqpartno() {
        return reqpartno;
    }

    public void setReqpartno(String reqpartno) {
        this.reqpartno = reqpartno;
    }
    public String getReqpartprice() {
        return reqpartprice;
    }

    public void setReqpartprice(String reqpartprice) {
        this.reqpartprice = reqpartprice;
    }
    public String getStandardpartno() {
        return standardpartno;
    }

    public void setStandardpartno(String standardpartno) {
        this.standardpartno = standardpartno;
    }
    public String getStandardprice() {
        return standardprice;
    }

    public void setStandardprice(String standardprice) {
        this.standardprice = standardprice;
    }
    public String getIstrue() {
        return istrue;
    }

    public void setIstrue(String istrue) {
        this.istrue = istrue;
    }
    public String getHandlercode() {
        return handlercode;
    }

    public void setHandlercode(String handlercode) {
        this.handlercode = handlercode;
    }
    public String getHandlername() {
        return handlername;
    }

    public void setHandlername(String handlername) {
        this.handlername = handlername;
    }
    public String getRepairfactoryname() {
        return repairfactoryname;
    }

    public void setRepairfactoryname(String repairfactoryname) {
        this.repairfactoryname = repairfactoryname;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExportData{" +
            "registno=" + registno +
            ", querytime=" + querytime +
            ", vincode=" + vincode +
            ", reqpartname=" + reqpartname +
            ", reqpartno=" + reqpartno +
            ", reqpartprice=" + reqpartprice +
            ", standardpartno=" + standardpartno +
            ", standardprice=" + standardprice +
            ", istrue=" + istrue +
            ", handlercode=" + handlercode +
            ", handlername=" + handlername +
            ", repairfactoryname=" + repairfactoryname +
            ", id=" + id +
        "}";
    }
}
