package com.curupira.controller;

import com.curupira.model.User;
import com.curupira.services.InitializerService;
import com.curupira.services.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private UserService userService;

    @Secured("ADMIN")
    @RequestMapping({"/admin/index", "/admin"})
    public String index(){
        logger.debug("ADMIN INDEX");
        return "admin/index";
    }

    @Secured("ADMIN")
    @RequestMapping({"/admin/users"})
    public String listUsers(Model model){
        List<User> users = userService.listAll(0);
        model.addAttribute("users",users);
        return "admin/users";
    }

}
