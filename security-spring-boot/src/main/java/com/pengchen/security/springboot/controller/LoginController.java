package com.pengchen.security.springboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/login‐success", produces = {"application/json;charset=UTF-8"})
    public String loginSuccess() {

        return getUsername() + "登录成功";
    }

    /**
     * 获取当前登录用户名
     */
    private String getUsername() {

        String username;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            username = "匿名";
            return username;
        }

        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            username =
                    ((org.springframework.security.core.userdetails.UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

    /**
     * 测试资源1
     */
    @GetMapping(value = "/r/r1", produces = {"application/json;charset=UTF-8"})
    public String r1() {
        return getUsername() + "访问资源1";
    }

    /**
     * 测试资源2
     */
    @GetMapping(value = "/r/r2", produces = {"application/json;charset=UTF-8"})
    public String r2() {
        return getUsername() + "访问资源2";
    }
}
