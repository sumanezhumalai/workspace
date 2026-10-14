package com.sumanezhumalai;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import com.sumanezhumalai.servlet.HelloServlet;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("Hello World!");

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);
        // empty path string , null directory - sets tomact to use defualts
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMapping("/hello", "HelloServlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
