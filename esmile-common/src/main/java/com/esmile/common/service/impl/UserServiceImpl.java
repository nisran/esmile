package com.esmile.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.esmile.common.domain.Role;
import com.esmile.common.domain.User;
import com.esmile.common.service.UserService;
import com.esmile.common.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByName(String userName) {
        final QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(USER_NAME, userName);
        return this.getOne(queryWrapper);
    }

    @Override
    public List<Role> getRolesByUserId(Long userId) {
        return userMapper.getRolesByUserId(userId);
    }
}
