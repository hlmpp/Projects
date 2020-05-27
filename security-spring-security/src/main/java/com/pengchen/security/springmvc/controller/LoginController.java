package com.pengchen.security.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/login‐success", produces = {"application/json;charset=UTF-8"})
    public String loginSuccess() {
        return "登录成功";
    }

    /**
     * 测试资源1
     */
    @GetMapping(value = "/r/r1", produces = {"application/json;charset=UTF-8"})
    public String r1() {
        return "访问资源1";
    }

    /**
     * 测试资源2
     */
    @GetMapping(value = "/r/r2", produces = {"application/json;charset=UTF-8"})
    public String r2() {
        return "访问资源2";
    }
}