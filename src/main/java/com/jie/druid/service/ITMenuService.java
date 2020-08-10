package com.jie.druid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jie.druid.entity.Menu;
import com.jie.druid.entity.MenuTree;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author wsj
 * @since 2020-08-06
 */
public interface ITMenuService extends IService<Menu> {
    /**
     * 查找用户权限集
     *
     * @param username 用户名
     * @return 用户权限集合
     */
    List<Menu> findUserPermissions(String username);

    /**
     * 查找用户菜单集合
     *
     * @param username 用户名
     * @return 用户菜单集合
     */
    MenuTree<Menu> findUserMenus(String username);

    /**
     * 查找所有的菜单/按钮 （树形结构）
     *
     * @param menu menu
     * @return MenuTree<Menu>
     */
    MenuTree<Menu> findMenus(Menu menu);

    /**
     * 查找所有的菜单/按钮
     *
     * @param menu menu
     * @return MenuTree<Menu>
     */
    List<Menu> findMenuList(Menu menu);

    /**
     * 新增菜单（按钮）
     *
     * @param menu 菜单（按钮）对象
     */
    void createMenu(Menu menu);

    /**
     * 修改菜单（按钮）
     *
     * @param menu 菜单（按钮）对象
     */
    void updateMenu(Menu menu);

    /**
     * 删除菜单（按钮）
     *
     * @param menuIds 菜单（按钮）id
     */
    void deleteMenus(String menuIds);
}
