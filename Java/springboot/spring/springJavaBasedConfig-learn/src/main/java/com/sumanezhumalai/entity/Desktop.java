package com.sumanezhumalai.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sumanezhumalai.entity.rule.Device;

@Component("IntelDesktop")
@Primary
@Scope("prototype")
public class Desktop implements Device {
    private String name;

    public Desktop() {
        System.out.println("Device object created.");
    }

    public Desktop(String name) {
        this.name = name;
        System.out.println("Device object created.");
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

    // custom method
    public void defaultDevice() {
        System.out.println("Intel Workstation Lite");
    }

    public void introduceYourself() {
        System.out.println("Im Desktop : class from entity layer");
    }
}
