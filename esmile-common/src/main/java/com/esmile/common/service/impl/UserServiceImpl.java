package com.esmile.common.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.esmile.common.base.PagedResult;
import com.esmile.common.constant.ErrorMsgConstance;
import com.esmile.common.domain.User;
import com.esmile.common.mapper.UserMapper;
import com.esmile.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserById(Integer userId) {
        Assert.notNull(userId, ErrorMsgConstance.UserError.USER_ID_NOT_NULL);

        return this.getById(userId);
    }

    @Override
    public PagedResult<User> getUserList(Long pageNo, Long pageSize) {
        final Page<User> page = new Page<>(pageNo, pageSize);
        final Page<User> pagedResult = this.page(page);
        return new PagedResult<User>( pagedResult.getTotal(), pagedResult.getRecords());
    }

    @Override
    @Transactional
    public User saveUser(User user) {

        final int userId = userMapper.insert(user);
        //刚插进去然后查询就报错
        // user= userMapper.selectById(userId);
        user.setUserId(user.getUserId());

        user.setPassword(null);
        logSave(user);
        return user;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        Assert.notNull(user.getUserId(), ErrorMsgConstance.UserError.USER_ID_NOT_NULL);

        final int userId = userMapper.updateById(user);
        return this.getById(userId);
    }

    @Override
    public boolean deleteUser(Integer userId) {
        Assert.notNull(userId, ErrorMsgConstance.UserError.USER_ID_NOT_NULL);
        return this.removeById(userId);
    }


    /**
     * Async方法不能是私有的？？
     * 暂时这样些，以后用切面的方式解决
     * @param user
     */
    @Async
    void logSave(User user){
        logger.info("Save user: {}", user);
    }
}
