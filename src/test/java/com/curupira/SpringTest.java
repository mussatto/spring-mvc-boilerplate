package com.curupira;

import com.curupira.config.PersistenceJPAConfig;
import com.curupira.config.ServiceConfig;
import com.curupira.dao.RoleDAO;
import com.curupira.model.Role;
import com.curupira.services.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class SpringTest {

    private ApplicationContext applicationContext;

    public SpringTest(){
        applicationContext = new AnnotationConfigApplicationContext(ServiceConfig.class, PersistenceJPAConfig.class);
        RoleService roleService = applicationContext.getBean(RoleService.class);

        roleService.createDefaultRoles();
    }

    public ApplicationContext getApplicationContext(){
        return applicationContext;
    }

}
