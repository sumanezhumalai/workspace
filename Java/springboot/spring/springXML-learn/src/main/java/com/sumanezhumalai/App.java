package com.sumanezhumalai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sumanezhumalai.entity.Device;
import com.sumanezhumalai.entity.User;

public class App {
    private static void title(String s) {
        System.out.println("\n--- " + s + " ---");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        title("Setter Injection (user)");
        User obj1 = context.getBean("user", User.class);
        System.out.println(obj1.getAge());
        System.out.println(obj1.getName());

        title("Singleton Scope (same user, 2nd lookup)");
        User obj2 = context.getBean("user", User.class);
        System.out.println(obj2.getAge());
        System.out.println(obj2.getName());

        title("Ref Attribute (user -> device)");
        obj2.getDefaultDevice();

        title("Constructor Injection (user3)");
        User obj3 = context.getBean("user3", User.class);
        System.out.println(obj3.toString());

        title("Autowire byType (userAuto, primary device wins)");
        User obj4 = context.getBean("userAuto", User.class);
        System.out.println(obj4.toString());
        obj4.getDefaultDevice();

        title("Autowire byName (userByName)");
        User obj5 = context.getBean("userByName", User.class);
        System.out.println(obj5.toString());
        obj5.getDefaultDevice();

        title("Lazy Init (backupDevice)");
        Device backup = context.getBean("backupDevice", Device.class);
        System.out.println(backup.toString());

        title("By-type Lookup (primary device)");
        Device primary = context.getBean(Device.class);
        System.out.println(primary.toString());

        title("Inner Bean (userInner, private InnerPad)");
        User obj6 = context.getBean("userInner", User.class);
        System.out.println(obj6.toString());
        obj6.getDefaultDevice();
    }
}
