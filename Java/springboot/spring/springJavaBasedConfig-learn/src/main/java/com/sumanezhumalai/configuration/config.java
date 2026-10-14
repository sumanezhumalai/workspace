package com.sumanezhumalai.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sumanezhumalai.entity.Desktop;
import com.sumanezhumalai.entity.Laptop;
import com.sumanezhumalai.entity.User;
import com.sumanezhumalai.entity.rule.Device;

@Configuration
@ComponentScan("com.sumanezhumalai")
public class config {
    // Declare Bean and other conf here, or could use /stereotype annotation/
    // @Component on respectove classes

    // @Bean(name = { "userIOC", "master" }) // camn specify a custom name or
    // // multiple custim name
    // @Scope("prototype")
    // // Singleton by default - shares a single object for all decalarations
    // // Prototype Creates N object for N decalaration not shared
    // public User user(@Qualifier("defaultDesktop") /*
    // * Explicitloy mention type as Qualifies or annotate the object with
    // * Primary (for on preferred object, Either laptop or desktop )
    // */Device device /*
    // * Autowire is managed default in modern verison
    // */) {
    // // If not, the method name is the default name for the User IOC object
    // // created and managed by Spring
    // User obj = new User();
    // obj.setAge(22);
    // obj.setName("Suman");
    // obj.setDevice(device);
    // return obj;
    // }

    // @Bean(name = "defaultLaptop")
    // public Laptop laptop() {
    // return new Laptop();
    // }

    // @Bean(name = "defaultDesktop")
    // @Primary
    // public Desktop desktop() {
    // return new Desktop();
    // }
}
