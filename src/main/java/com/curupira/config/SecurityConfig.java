package com.curupira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        String prefix = "/WEB-INF/view/admin";
        String sufix = "jsp";
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix(prefix);
        internalResourceViewResolver.setSuffix(sufix);

        return internalResourceViewResolver;
    }
}
