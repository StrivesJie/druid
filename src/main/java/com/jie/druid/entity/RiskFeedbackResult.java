package com.jie.druid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wsj
 * @since 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RiskFeedbackResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 案件号
     */
    private String registno;

    /**
     * 处理完成时间
     */
    private LocalDateTime endtime;

    /**
     * 状态（0:失败，1:成功）
     */
    private String status;

    /**
     * 处理结果
     */
    private String result;

    /**
     * 信息接收人
     */
    private String receiver;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 处理方式（1:短信，2:回写）
     */
    private String mode;

    /**
     * 车牌号
     */
    private String licenseno;


}
