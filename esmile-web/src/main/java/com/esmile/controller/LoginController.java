package com.esmile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "Success";
    }

    @GetMapping("/authCheck")
    public String authCheck() {
        return "Success";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "Welcome";
    }

}
