package com.sumanezhumalai.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sumanezhumalai.entity.rule.Device;

@Component
public class User {

    // Specifying Default value
    @Value("21")
    // private int age = 18; //tight bound
    private int age;

    private String name;
    @Autowired // Could mention primary annotation on one compoenent class of same Interface
               // type to default to.
    // @Qualifier("laptop") // by default the name would be the component class in
    // lowercase
    // @Qualifier("IntelDesktop") //explicit mention of qualifier always taked
    // precedence over the primary component of the same type
    private Device device;

    public User() {
        System.out.println("User Object Created");
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("User Object Created");
    }

    public User(int age, String name, Laptop device) {
        this.age = age;
        this.name = name;
        this.device = device;
        System.out.println("User Object Created");
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

    // @Autowired
    // @Qualifier("laptop")
    public void setDevice(Device device) {
        this.device = device;
    }

    // Custom Methods

    public void getDefaultDevice() {
        device.defaultDevice();
    }

    public void introduceYourself() {
        System.out.println("Im User : class from entity layer");
    }

    /*
     * @Autowired -> types - field injestion(class), Constructor injestion, Setter
     * injestion
     */
}
