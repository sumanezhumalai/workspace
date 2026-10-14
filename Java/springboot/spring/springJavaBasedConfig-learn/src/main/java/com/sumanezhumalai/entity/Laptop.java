package com.sumanezhumalai.entity;

import org.springframework.stereotype.Component;

import com.sumanezhumalai.entity.rule.Device;

@Component
public class Laptop implements Device {
    private String name;

    public Laptop() {
        System.out.println("Device object created.");
    }

    public Laptop(String name) {
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
        System.out.println("ThinkPad");
    }

    public void introduceYourself() {
        System.out.println("Im Laptop : class from entity layer");
    }
}
