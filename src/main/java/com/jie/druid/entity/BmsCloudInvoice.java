package com.jie.druid.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 平台发票管理表
 * </p>
 *
 * @author wsj
 * @since 2019-11-06
 */
public class BmsCloudInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 发票id(uuid)	pk
     */
    private String invid;

    /**
     * 公司id fk
     */
    private String companyid;

    /**
     * 发票字典ID	fk
     */
    private String dictid;

    /**
     * 快递公司id
     */
    private String expressid;

    /**
     * 几张合并为一张,以逗号分隔
     */
    private String invrecids;

    /**
     * 发票号码
     */
    private String invnumber;

    /**
     * 发票代码
     */
    private String invcode;

    /**
     * 申请金额
     */
    private String invmoney;

    /**
     * 发票状态
     */
    private Integer invstatus;

    /**
     * 驳回原因
     */
    private String rejectreason;

    /**
     * 投递状态	0未投递、1投递
     */
    private Integer poststatus;

    /**
     * 快递单号
     */
    private String postnumber;

    private LocalDateTime postdate;

    /**
     * 发票是否被打印	0不开,1已开
     */
    private Integer invispring;

    /**
     * 申请人id	fk
     */
    private String inputmanid;

    /**
     * 创建时间
     */
    private LocalDateTime credate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getInvid() {
        return invid;
    }

    public void setInvid(String invid) {
        this.invid = invid;
    }
    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }
    public String getDictid() {
        return dictid;
    }

    public void setDictid(String dictid) {
        this.dictid = dictid;
    }
    public String getExpressid() {
        return expressid;
    }

    public void setExpressid(String expressid) {
        this.expressid = expressid;
    }
    public String getInvrecids() {
        return invrecids;
    }

    public void setInvrecids(String invrecids) {
        this.invrecids = invrecids;
    }
    public String getInvnumber() {
        return invnumber;
    }

    public void setInvnumber(String invnumber) {
        this.invnumber = invnumber;
    }
    public String getInvcode() {
        return invcode;
    }

    public void setInvcode(String invcode) {
        this.invcode = invcode;
    }
    public String getInvmoney() {
        return invmoney;
    }

    public void setInvmoney(String invmoney) {
        this.invmoney = invmoney;
    }
    public Integer getInvstatus() {
        return invstatus;
    }

    public void setInvstatus(Integer invstatus) {
        this.invstatus = invstatus;
    }
    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason;
    }
    public Integer getPoststatus() {
        return poststatus;
    }

    public void setPoststatus(Integer poststatus) {
        this.poststatus = poststatus;
    }
    public String getPostnumber() {
        return postnumber;
    }

    public void setPostnumber(String postnumber) {
        this.postnumber = postnumber;
    }
    public LocalDateTime getPostdate() {
        return postdate;
    }

    public void setPostdate(LocalDateTime postdate) {
        this.postdate = postdate;
    }
    public Integer getInvispring() {
        return invispring;
    }

    public void setInvispring(Integer invispring) {
        this.invispring = invispring;
    }
    public String getInputmanid() {
        return inputmanid;
    }

    public void setInputmanid(String inputmanid) {
        this.inputmanid = inputmanid;
    }
    public LocalDateTime getCredate() {
        return credate;
    }

    public void setCredate(LocalDateTime credate) {
        this.credate = credate;
    }

    @Override
    public String toString() {
        return "BmsCloudInvoice{" +
            "id=" + id +
            ", invid=" + invid +
            ", companyid=" + companyid +
            ", dictid=" + dictid +
            ", expressid=" + expressid +
            ", invrecids=" + invrecids +
            ", invnumber=" + invnumber +
            ", invcode=" + invcode +
            ", invmoney=" + invmoney +
            ", invstatus=" + invstatus +
            ", rejectreason=" + rejectreason +
            ", poststatus=" + poststatus +
            ", postnumber=" + postnumber +
            ", postdate=" + postdate +
            ", invispring=" + invispring +
            ", inputmanid=" + inputmanid +
            ", credate=" + credate +
        "}";
    }
}
