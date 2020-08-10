package com.jie.druid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jie.druid.entity.RoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单关联表 服务类
 * </p>
 *
 * @author wsj
 * @since 2020-08-06
 */
public interface ITRoleMenuService extends IService<RoleMenu> {
    /**
     * 通过角色 id 删除
     *
     * @param roleIds 角色 id
     */
    void deleteRoleMenusByRoleId(List<String> roleIds);

    /**
     * 通过菜单（按钮）id 删除
     *
     * @param menuIds 菜单（按钮）id
     */
    void deleteRoleMenusByMenuId(List<String> menuIds);
}
