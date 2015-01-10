package com.curupira.controller;

import com.curupira.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService){
        this.userService=userService;
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/admin/index")
    public String index(){
        return "admin/index";
    }

    @RequestMapping("/createDefault")
    public String createDefault(){

        userService.createDefaultAdmin();
        return "createDefault";
    }
}
