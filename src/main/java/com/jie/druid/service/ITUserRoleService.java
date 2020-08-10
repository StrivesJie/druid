package com.jie.druid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jie.druid.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author wsj
 * @since 2020-08-06
 */
public interface ITUserRoleService extends IService<UserRole> {
    /**
     * 通过角色 id 删除
     *
     * @param roleIds 角色 id
     */
    void deleteUserRolesByRoleId(List<String> roleIds);

    /**
     * 通过用户 id 删除
     *
     * @param userIds 用户 id
     */
    void deleteUserRolesByUserId(List<String> userIds);
}
