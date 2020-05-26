package com.pengchen.security.springmvc.controller;

import com.pengchen.security.springmvc.model.AuthenticationRequest;
import com.pengchen.security.springmvc.model.UserDto;
import com.pengchen.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession httpSession) {

        UserDto userDto = authenticationService.authentication(authenticationRequest);

        // 存入session
        httpSession.setAttribute(UserDto.SESSION_USER_KEY, userDto);
        return userDto.getUsername() + "登录成功";
    }

    @GetMapping(value = "/logout",produces = "application/json;charset=UTF-8")
    public String logout(HttpSession session){
        // session失效就可以
        session.invalidate();
        return "退出成功";
    }

    /**
     * 测试资源1
     */
    @GetMapping(value = "/r/r1", produces = {"application/json;charset=UTF-8"})
    public String r1(HttpSession session) {
        String fullname;

        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userObj != null) {
            fullname = ((UserDto) userObj).getFullname();
        } else {
            fullname = "匿名";
        }
        return fullname + " 访问资源1";
    }

    /**
     * 测试资源2
     */
    @GetMapping(value = "/r/r2", produces = {"application/json;charset=UTF-8"})
    public String r2(HttpSession session) {
        String fullname;

        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userObj != null) {
            fullname = ((UserDto) userObj).getFullname();
        } else {
            fullname = "匿名";
        }
        return fullname + " 访问资源2";
    }
}
