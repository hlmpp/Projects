package com.pengchen.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 充当applicationcontext.xml, 但是controller注解是不需要扫描(其中包括了servlet配置类, WebConfig)
 * 在此配置除了Controller的其它bean, 比如: 数据库链接池, 事务管理器, 业务bean等
 */
@Configuration
@ComponentScan(basePackages = "com.pengchen.security.springmvc",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {


}
