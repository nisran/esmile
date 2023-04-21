package com.esmile.controller;

import com.esmile.common.base.GenericResult;
import com.esmile.common.base.PagedResult;
import com.esmile.common.domain.User;
import com.esmile.common.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Classname UserController
 * @Description TODO
 * @Version 1.0.0
 * @Date 11/3/2023 下午9:26
 * @Created by nisran
 */
@RestController
@RequestMapping("admin/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/{userId}")
    public GenericResult getUserById(@PathParam("userId") Integer userId){
        User result = userService.getUserById(userId);
        return GenericResult.SuccessData(result);
    }

    @GetMapping
    public PagedResult<User> getUserList(Long pageNo, Long pageSize){
        return userService.getUserList(pageNo, pageSize);
    }

    @PostMapping
    public GenericResult saveUser(@RequestBody User user){
        User result = userService.saveUser(user);
        return GenericResult.SuccessData(result);
    }

    @PutMapping()
    public GenericResult updateUser(@RequestBody User user){
        User result = userService.updateUser(user);
        return GenericResult.SuccessData(result);
    }

    @DeleteMapping("{userId}")
    public GenericResult deleteUser(@PathParam("userId") Integer userId){
        userService.deleteUser(userId);
        return GenericResult.Success();
    }

}
