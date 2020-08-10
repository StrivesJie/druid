package com.jie.druid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jie.druid.entity.UserDataPermission;
import com.jie.druid.mapper.TUserDataPermissionDao;
import com.jie.druid.service.ITUserDataPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户数据权限关联表 服务实现类
 * </p>
 *
 * @author wsj
 * @since 2020-08-06
 */
@Service("userDataPermissionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TUserDataPermissionServiceImpl extends ServiceImpl<TUserDataPermissionDao, UserDataPermission> implements ITUserDataPermissionService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByDeptIds(List<String> deptIds) {
        this.baseMapper.delete(new LambdaQueryWrapper<UserDataPermission>().in(UserDataPermission::getDeptId, deptIds));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByUserIds(String[] userIds) {
        List<String> list = Arrays.asList(userIds);
        this.baseMapper.delete(new LambdaQueryWrapper<UserDataPermission>().in(UserDataPermission::getUserId, list));
    }

    @Override
    public String findByUserId(String userId) {
        LambdaQueryWrapper<UserDataPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDataPermission::getUserId, userId);
        return this.baseMapper.selectList(wrapper).stream().map(permission -> String.valueOf(permission.getDeptId())).collect(Collectors.joining(StringPool.COMMA));
    }
}
