package com.curupira.controller;

import com.curupira.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private UserService userService;

    @RequestMapping("/")
    public String loadHomePage(Model m){

        m.addAttribute("name", "you");
        return "home";
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
