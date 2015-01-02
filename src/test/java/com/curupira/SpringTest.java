package com.curupira;

import com.curupira.config.PersistenceJPAConfig;
import com.curupira.config.ServiceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class SpringTest {

    private ApplicationContext applicationContext;

    public SpringTest(){
        applicationContext = new AnnotationConfigApplicationContext(ServiceConfig.class, PersistenceJPAConfig.class);
    }

}
