package com.jie.druid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wsj
 * @since 2019-11-07
 */
public class RuleModelResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 报案号
     */
    private String registno;

    /**
     * 报案时间
     */
    private LocalDateTime reporttime;

    /**
     * 模型匹配时间
     */
    private LocalDateTime matchtime;

    /**
     * 风险模型ID
     */
    private Long modelInfoId;

    /**
     * 风险模型参数
     */
    private String modelParam;

    /**
     * 模型编号
     */
    private String code;

    /**
     * 模型名称
     */
    private String name;

    /**
     * 风险等级数字1，2，3。。。
     */
    private Integer risk;

    /**
     * 触发提示
     */
    private String tip;

    /**
     * 备注
     */
    private String remark;

    /**
     * 结果来源：0，前置，1为风险模型匹配，2为黑名单
     */
    private String origin;

    /**
     * 派工系统匹配时间
     */
    private LocalDateTime pgMatchtime;

    /**
     * ai处理时间
     */
    private LocalDateTime aiProcTime;

    /**
     * ai处理结果
     */
    private String aiProcResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRegistno() {
        return registno;
    }

    public void setRegistno(String registno) {
        this.registno = registno;
    }
    public LocalDateTime getReporttime() {
        return reporttime;
    }

    public void setReporttime(LocalDateTime reporttime) {
        this.reporttime = reporttime;
    }
    public LocalDateTime getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(LocalDateTime matchtime) {
        this.matchtime = matchtime;
    }
    public Long getModelInfoId() {
        return modelInfoId;
    }

    public void setModelInfoId(Long modelInfoId) {
        this.modelInfoId = modelInfoId;
    }
    public String getModelParam() {
        return modelParam;
    }

    public void setModelParam(String modelParam) {
        this.modelParam = modelParam;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getRisk() {
        return risk;
    }

    public void setRisk(Integer risk) {
        this.risk = risk;
    }
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public LocalDateTime getPgMatchtime() {
        return pgMatchtime;
    }

    public void setPgMatchtime(LocalDateTime pgMatchtime) {
        this.pgMatchtime = pgMatchtime;
    }
    public LocalDateTime getAiProcTime() {
        return aiProcTime;
    }

    public void setAiProcTime(LocalDateTime aiProcTime) {
        this.aiProcTime = aiProcTime;
    }
    public String getAiProcResult() {
        return aiProcResult;
    }

    public void setAiProcResult(String aiProcResult) {
        this.aiProcResult = aiProcResult;
    }

    @Override
    public String toString() {
        return "RuleModelResult{" +
            "id=" + id +
            ", registno=" + registno +
            ", reporttime=" + reporttime +
            ", matchtime=" + matchtime +
            ", modelInfoId=" + modelInfoId +
            ", modelParam=" + modelParam +
            ", code=" + code +
            ", name=" + name +
            ", risk=" + risk +
            ", tip=" + tip +
            ", remark=" + remark +
            ", origin=" + origin +
            ", pgMatchtime=" + pgMatchtime +
            ", aiProcTime=" + aiProcTime +
            ", aiProcResult=" + aiProcResult +
        "}";
    }
}
