package com.jie.druid.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户数据权限关联表
 * </p>
 *
 * @author wsj
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserDataPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("USER_ID")
    private Long userId;

    @TableField("DEPT_ID")
    private Long deptId;


}
