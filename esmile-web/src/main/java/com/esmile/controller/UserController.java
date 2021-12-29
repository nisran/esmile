// package com.esmile.controller;
//
// import com.esmile.common.base.ResultMessage;
// import com.esmile.common.domain.User;
// import com.esmile.common.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
//
// @RestController
// @RequestMapping("/user")
// public class UserController {
//
//     @Autowired
//     private UserService userService;
//
//     @PostMapping("/login")
//     public ResultMessage login(@RequestBody User user) {
//         return ResultMessage.SuccessResult();
//     }
//
//     @GetMapping("/logout")
//     public ResultMessage logout() {
//         return ResultMessage.SuccessResult();
//     }
//
//     @PostMapping("/save")
//     public ResultMessage SaveUser(@RequestBody User user) {
//         userService.save(user);
//         return ResultMessage.SuccessResult();
//     }
//
// }
