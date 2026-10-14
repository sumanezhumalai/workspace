package com.sumanezhumalai.spring_learn.entity;

import com.sumanezhumalai.spring_learn.entity.rule.Computer;

public class Device implements Computer {
    private String name;

    public Device(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Device [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Device() {
        System.out.println("Device object created.");
    }

    public void defaultDevice() {
        System.out.println("ThinkPad.");
    }
}
