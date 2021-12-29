package com.esmile.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esmile.common.domain.Role;
import com.esmile.common.domain.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<Role> getRolesByUserId(Long userId);
}

