package com.socius.origin.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String helloMessage() {
        return "Hello from Socius App's service Layer!";
    }

    public String aboutMessage() {
        return "Socius is about calming personalized productivity app , Hand built by Suman";
    }
}
