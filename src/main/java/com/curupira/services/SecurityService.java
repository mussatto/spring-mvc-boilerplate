package com.curupira.services;

import com.curupira.model.Role;
import com.curupira.model.User;
import com.curupira.spring.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SecurityService {

    @Autowired
    private UserService userService;

    public SecurityUser login(String username){
        User user = userService.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Username "+username+" not found");
        }
        System.out.println("Role");
        System.out.println(user.getEmail());
        for(Role role : user.getRoles()){
            System.out.println(role.getRoleName());
        }
        return new SecurityUser(user);
    }
}
