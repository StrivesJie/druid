package com.jie.druid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jie.druid.config.shiro.ShiroRealm;
import com.jie.druid.entity.Menu;
import com.jie.druid.entity.MenuTree;
import com.jie.druid.entity.TreeUtil;
import com.jie.druid.mapper.TMenuDao;
import com.jie.druid.service.ITMenuService;
import com.jie.druid.service.ITRoleMenuService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author wsj
 * @since 2020-08-06
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TMenuServiceImpl extends ServiceImpl<TMenuDao, Menu> implements ITMenuService {
    private final ITRoleMenuService roleMenuService;
    private final ShiroRealm shiroRealm;

    @Override
    public List<Menu> findUserPermissions(String username) {
        return this.baseMapper.findUserPermissions(username);
    }

    @Override
    public MenuTree<Menu> findUserMenus(String username) {
        List<Menu> menus = this.baseMapper.findUserMenus(username);
        List<MenuTree<Menu>> trees = this.convertMenus(menus);
        return TreeUtil.buildMenuTree(trees);
    }

    @Override
    public MenuTree<Menu> findMenus(Menu menu) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(menu.getMenuName())) {
            queryWrapper.lambda().like(Menu::getMenuName, menu.getMenuName());
        }
        queryWrapper.lambda().orderByAsc(Menu::getOrderNum);
        List<Menu> menus = this.baseMapper.selectList(queryWrapper);
        List<MenuTree<Menu>> trees = this.convertMenus(menus);

        return TreeUtil.buildMenuTree(trees);
    }

    @Override
    public List<Menu> findMenuList(Menu menu) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(menu.getMenuName())) {
            queryWrapper.lambda().like(Menu::getMenuName, menu.getMenuName());
        }
        queryWrapper.lambda().orderByAsc(Menu::getMenuId);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createMenu(Menu menu) {
        menu.setCreateTime(LocalDateTime.now());
        this.setMenu(menu);
        this.baseMapper.insert(menu);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(Menu menu) {
        menu.setModifyTime(LocalDateTime.now());
        this.setMenu(menu);
        this.baseMapper.updateById(menu);

        shiroRealm.clearCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMenus(String menuIds) {
        String[] menuIdsArray = menuIds.split(StringPool.COMMA);
        this.delete(Arrays.asList(menuIdsArray));

        shiroRealm.clearCache();
    }

    private List<MenuTree<Menu>> convertMenus(List<Menu> menus) {
        List<MenuTree<Menu>> trees = new ArrayList<>();
        menus.forEach(menu -> {
            MenuTree<Menu> tree = new MenuTree<>();
            tree.setId(String.valueOf(menu.getMenuId()));
            tree.setParentId(String.valueOf(menu.getParentId()));
            tree.setTitle(menu.getMenuName());
            tree.setIcon(menu.getIcon());
            tree.setHref(menu.getUrl());
            tree.setData(menu);
            trees.add(tree);
        });
        return trees;
    }

    private void setMenu(Menu menu) {
        if (menu.getParentId() == null) {
            menu.setParentId(Menu.TOP_NODE);
        }
        if (Menu.TYPE_BUTTON.equals(menu.getType())) {
            menu.setUrl(null);
            menu.setIcon(null);
        }
    }

    private void delete(List<String> menuIds) {
        List<String> list = new ArrayList<>(menuIds);
        removeByIds(menuIds);

        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Menu::getParentId, menuIds);
        List<Menu> menus = baseMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(menus)) {
            List<String> menuIdList = new ArrayList<>();
            menus.forEach(m -> menuIdList.add(String.valueOf(m.getMenuId())));
            list.addAll(menuIdList);
            this.roleMenuService.deleteRoleMenusByMenuId(list);
            this.delete(menuIdList);
        } else {
            this.roleMenuService.deleteRoleMenusByMenuId(list);
        }
    }
}