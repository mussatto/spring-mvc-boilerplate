package com.curupira.config;

import com.curupira.dao.RoleDAO;
import com.curupira.dao.UserDAO;
import com.curupira.services.RoleService;
import com.curupira.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean(name = "RoleDAO")
    public RoleDAO getRoleDAO(){
        return new RoleDAO();
    }

    @Bean(name="UserDAO")
    public UserDAO getUserDAO(){
        return new UserDAO();
    }

    @Bean(name = "RoleService")
    public RoleService getRoleService(){
        return new RoleService();
    }

    @Bean(name = "UserService")
    public UserService getUserService(){
        return new UserService();
    }



}
