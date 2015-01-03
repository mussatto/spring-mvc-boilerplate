package com.curupira.dao;

import com.curupira.SpringTest;
import org.junit.Test;

public class UserDAOTest extends SpringTest {

    @Test
    public void defaultUserTest(){
        UserDAO userDAO = getApplicationContext().getBean(UserDAO.class);


    }
}
