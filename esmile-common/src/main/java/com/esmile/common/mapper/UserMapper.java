package com.esmile.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esmile.common.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    // List<Role> getRolesByUserId(Long userId);
}

