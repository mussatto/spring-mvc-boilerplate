package com.curupira.controller;

import com.curupira.model.RoleName;
import com.curupira.services.InitializerService;
import com.curupira.services.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private InitializerService initializerService;

    public void setUserService(UserService userService){
        this.userService=userService;
    }

    @Secured("ADMIN")
    @RequestMapping({"/admin/index", "/admin"})
    public String index(){
        System.out.println("ADMIN INDEX");
        return "admin/index";
    }

}
