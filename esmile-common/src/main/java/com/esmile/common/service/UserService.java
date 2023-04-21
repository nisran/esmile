package com.esmile.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.esmile.common.base.PagedResult;
import com.esmile.common.constant.domain.UserConstant;
import com.esmile.common.domain.User;

public interface UserService extends IService<User>, UserConstant {

    User getUserById(Integer userId);
    PagedResult<User> getUserList(Long pageNo, Long pageSize);
    User saveUser(User user);
    User updateUser(User user);
    boolean deleteUser(Integer userId);


}
