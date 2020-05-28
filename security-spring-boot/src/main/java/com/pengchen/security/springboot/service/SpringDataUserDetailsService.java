package com.pengchen.security.springboot.service;

import com.pengchen.security.springboot.Dao.UserDao;
import com.pengchen.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    // 被注释的是直接拿内存的方式
//    // 根据账号查询用户信息
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //登录账号
//        System.out.println("username="+username);
//        //根据账号去数据库查询...
//        //这里暂时使用静态数据
//        UserDetails userDetails = User.withUsername("zhangsan")
//                .password("$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm").authorities("p1").build();
//        return userDetails;
//    }

    // 以下是用数据库验证的方式
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //登录账号
        System.out.println("username=" + username);

        //根据账号去数据库查询...
        UserDto user = userDao.getUserByUsername(username);

        if (user == null) {
            return null;
        }

        //这里暂时使用静态数据
        return User.withUsername(user.getFullname()).password(user.getPassword()).authorities("p1").build();
    }
}
