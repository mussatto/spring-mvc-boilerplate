package com.curupira.services;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializerService implements InitializingBean {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService){
        this.userService=userService;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        userService.createDefaultAdmin();
    }
}
