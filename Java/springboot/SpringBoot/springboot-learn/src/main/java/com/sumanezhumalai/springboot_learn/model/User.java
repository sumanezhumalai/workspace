package com.sumanezhumalai.springboot_learn.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sumanezhumalai.springboot_learn.model.rule.Device;

@Component
public class User {

    @Value("21")
    private int age;
    private String name;

    private Device device;

    public User() {
        System.out.println("User Object Created");
    }

    public User(int age, String name, Device device) {
        this.age = age;
        this.name = name;
        this.device = device;
        System.out.println("Parameterized constructor called");
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + ", device=" + device + "]";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Age setter called");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Name setter called");
        this.name = name;
    }

    @Autowired
    public void setDevice(Device device) {
        this.device = device;
    }

    // custom methods
    public void getDefaultDevice() {
        device.defaultDevice();
    }

    public void introduceYourself() {
        System.out.println("Im User:class from entity layer");
    }

}
