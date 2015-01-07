package com.curupira.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Secured("ROLE_ADMIN")
    @RequestMapping("/admin/index")
    public String index(){
        return "admin/index";
    }
}
