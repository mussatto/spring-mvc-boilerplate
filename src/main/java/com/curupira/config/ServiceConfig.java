package com.curupira.config;

import com.curupira.dao.RoleDAO;
import com.curupira.services.RoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean(name = "RoleDAO")
    public RoleDAO getRoleDAO(){
        return new RoleDAO();
    }

    @Bean(name = "RoleService")
    public RoleService getRoleService(){
        return new RoleService();
    }



}
