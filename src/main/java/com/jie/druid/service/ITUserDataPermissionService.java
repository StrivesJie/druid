package com.jie.druid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jie.druid.entity.UserDataPermission;

import java.util.List;

/**
 * <p>
 * 用户数据权限关联表 服务类
 * </p>
 *
 * @author wsj
 * @since 2020-08-06
 */
public interface ITUserDataPermissionService extends IService<UserDataPermission> {
    /**
     * 通过部门ID删除关联关系
     *
     * @param deptIds 部门id
     */
    void deleteByDeptIds(List<String> deptIds);

    /**
     * 通过用户ID删除关联关系
     *
     * @param userIds 用户id
     */
    void deleteByUserIds(String[] userIds);

    /**
     * 通过用户ID查找关联关系
     *
     * @param userId 用户id
     * @return 关联关系
     */
    String findByUserId(String userId);
}
