package com.pengchen.security.springmvc.init;

import com.pengchen.security.springmvc.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SpringSecurityApplicationInitializer() {
        // super(WebSecurityConfig.class);
    }
}
