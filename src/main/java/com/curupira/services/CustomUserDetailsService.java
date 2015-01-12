package com.curupira.services;

import com.curupira.model.Role;
import com.curupira.model.User;
import com.curupira.spring.SecurityUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("C=CustomUserDetailsService,M=loadUserByUsername,p=username:"+username);
        User user = userService.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Username "+username+" not found");
        }

        System.out.println("------------------------");
        System.out.println("email:"+user.getEmail());
        for(Role role : user.getRoles()){
            System.out.println(role.getRoleName());
        }
        return new SecurityUser(user);
    }
}
