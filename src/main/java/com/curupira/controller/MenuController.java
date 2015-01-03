package com.curupira.controller;

import com.curupira.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @RequestMapping(value = {"/","/home"})
    public String index(Model m){

        m.addAttribute("name", "you");
        return "home";
    }

    @RequestMapping("/contact")
    public String contact(Model m){

        m.addAttribute("name", "you");
        return "contact";
    }

    @RequestMapping("/about")
    public String about(Model m){

        m.addAttribute("name", "you");
        return "about";
    }


}
