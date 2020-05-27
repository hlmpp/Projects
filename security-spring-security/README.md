# Spring Security结合Spring MVC

## Spring Security主要是节省了很多代码
- 比如拦截器可以不用配置
- Spring Security默认会提供一个登录页面

## 搭建步骤

- 定义WebSecurityConfig, 继承WebSecurityConfigurerAdapter
    ```text
    spring security提供了用户名密码登录、退出、会话管理等认证功能，只需要配置即可使用。
    在config包下定义WebSecurityConfig，安全配置的内容包括：用户信息、密码编码器、安全拦截机制。
    ```
    
- Spring Security初始化
    - 若当前环境没有使用Spring或Spring MVC，则需要将 WebSecurityConfig(Spring Security配置类) 传入超
      类，以确保获取配置，并创建spring context。
      
    - 相反，若当前环境已经使用spring，我们应该在现有的springContext中注册Spring Security(上一步已经做将
      WebSecurityConfig加载至rootcontext(就是步骤一))，此方法可以什么都不做。
      
- 默认根路径请求
    - 在WebConfig.java中添加默认请求根路径跳转到/login，此url为spring security提供。
    
- 认证成功页面
    - 在安全配置中，认证成功将跳转到/login-success
    ```text
    WebSecurityConfig的配置，LoginController的配置
    ```
    
- idea跑动项目配置maven，然后运行命令为clean tomcat7:run