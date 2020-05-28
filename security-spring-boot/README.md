# Spring Security结合Spring boot

## 搭建maven工程，导入依赖

## 配置webconfig以及配置文件
- 因为springboot的自动装配属性，所以一些注解不需要了

## 配置webSecurityConfig
- 因为springboot的自动装配属性，所以一些注解不需要了

## 相比于spring需要init的一些配置，这里springboot就不需要了

## 启动测试直接运行main方法

## 然后自定义UserDetailsService
- 定义完成后，可以屏蔽WebSecurityConfig的UserDetailsService

## 自定义PasswordEncoder
- WebSecurityConfig中定义

## 自定义登录jspr
- 注意csrf，也可以用以下方式兼容
```text
<form action="login" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
...
</form>
```

## 连接数据库认证

- 首先创建user_db数据库

   - 数据表使用flyway方式创建，注意文件夹是db/migration这样创建，不是db.migration这样创建。
   
- 用户表已经在sql中写明

## 会话保证
- 这个看pdf文档，默认是创建

## 自定义登出

## 定义数据库权限角色，实现授权管理

## 目前是web授权

- 规则的顺序是重要的，更具体的规则应该先写。

