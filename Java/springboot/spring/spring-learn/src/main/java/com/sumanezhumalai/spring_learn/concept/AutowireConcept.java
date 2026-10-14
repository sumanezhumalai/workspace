package com.sumanezhumalai.spring_learn.concept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sumanezhumalai.spring_learn.entity.User;

@Component
public class AutowireConcept {

    @Autowired // Auto dependency injection
    User user;

    public void run() {
        user.introduceYourself();
    }
}
