package com.sumanezhumalai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sumanezhumalai.configuration.config;
import com.sumanezhumalai.entity.User;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(config.class);

        User user1 = context.getBean("user", User.class);
        System.out.println(user1);
        user1.getDefaultDevice();
    }
}
