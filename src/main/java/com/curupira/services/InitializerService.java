package com.curupira.services;

import com.curupira.model.RoleName;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitializerService implements InitializingBean {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService){
        this.userService=userService;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        //TODO: case environment dev / prod / uat
        List<RoleName> roleList = new ArrayList<RoleName>();

        roleList.add(RoleName.ADMIN);

        userService.createUser("admin@curupira.com", "curupira","curupira",roleList);
    }
}
