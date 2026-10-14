package com.sumanezhumalai.springboot_learn.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sumanezhumalai.springboot_learn.model.rule.Device;

@Component
// @Primary
public class Laptop implements Device {
    private String name;

    public Laptop() {
        System.out.println("Laptop object created.");
    }

    public Laptop(String name) {
        this.name = name;
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

    // Custom Methods
    public void defaultDevice() {
        System.out.println("ThinkPad.");
    }

    public void introduceYourself() {
        System.out.println("Im Desktop : class from entity layer");
    }

}
