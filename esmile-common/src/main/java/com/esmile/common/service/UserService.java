package com.esmile.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.esmile.common.constant.domain.UserConstant;
import com.esmile.common.domain.Role;
import com.esmile.common.domain.User;

import java.util.List;

public interface UserService extends IService<User>, UserConstant {

    User getByName(String userName);

    public List<Role> getRolesByUserId(Long userId);

}
