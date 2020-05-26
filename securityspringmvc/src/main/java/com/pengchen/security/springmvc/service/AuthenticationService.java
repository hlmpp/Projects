package com.pengchen.security.springmvc.service;

import com.pengchen.security.springmvc.model.AuthenticationRequest;
import com.pengchen.security.springmvc.model.UserDto;

/**
 * 认证服务
 */
public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求, 包含用户名和密码
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
