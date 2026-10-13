package com.sumanezhumalai.entity;

import java.beans.ConstructorProperties;

public class User {

    private int age;
    private String name;

    private Device device; // injected bean (via ref), not created with new.

    @ConstructorProperties({ "age", "device" }) // for constructor-arg injuction by name
    public User(int age, String name, Device device) {
        this.age = age; // constructor injection point: values come from <constructor-arg>.
        this.name = name;
        this.device = device;
        System.out.println("Parameterized constructor called");
    }

    public User() {
        System.out.println("Object Created");
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + ", device=" + device + "]";
    }

    public void introduceYourself() {
        System.out.println("Im User:class from entity layer");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Age setter called"); // proof Spring called this via <property name="age">
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Name setter called"); // proof Spring called this via <property name="name">
        this.name = name;
    }

    // Ref injection point: Spring passes the "device" bean here.
    public void setDevice(Device device) {
        System.out.println("Device setter called"); // proof Spring called this via <property ref>
        this.device = device;
    }

    public void getDefaultDevice() {
        device.defaultDevice(); // uses injected bean — NPE here means ref wiring missing.
    }

}
