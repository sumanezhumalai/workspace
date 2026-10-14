package com.sumanezhumalai.springboot_learn.model;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sumanezhumalai.springboot_learn.model.rule.Device;

@Component("IntelDesktop")
@Primary
@Scope("prototype")
public class Desktop implements Device {
    private String name;

    public Desktop() {
        System.out.println("Desktop object created.");
    }

    public Desktop(String name) {
        this.name = name;
        System.out.println("Desktop object created.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("Device [name=" + name + "] Type : " + this.getClass());
    }

    // custom methods
    public void defaultDevice() {
        System.out.println("Intel Workstation Lite");
    }

    public void introduceYourself() {
        System.out.println("Im Desktop : class from entity layer");
    }
}