package com.pengchen.security.springmvc.init;

import com.pengchen.security.springmvc.config.ApplicationConfig;
import com.pengchen.security.springmvc.config.WebConfig;
import com.pengchen.security.springmvc.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 实现WebApplicationInitializer接口,
 * Spring容器启动时加载WebApplicationInitializer接口的所有实现类
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    // Spring容器, 相当于加载了applicationcontext.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class, WebSecurityConfig.class};
    }

    // ServletContext, 相当于加载了springmvc.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    // url-mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
