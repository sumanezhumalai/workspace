package com.sumanezhumalai.concept;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Configurations {

    // configuring --------------

    // Configuration cfg = new Configuration();
    // cfg.addAnnotatedClass(com.sumanezhumalai.Employee.class);
    // cfg.configure();

    // SessionFactory sf = cfg.buildSessionFactory();

    final static private SessionFactory sf = new Configuration()
            .addAnnotatedClass(com.sumanezhumalai.Model.Employee.class)
            .addAnnotatedClass(com.sumanezhumalai.Model.Device.class)
            .addAnnotatedClass(com.sumanezhumalai.Model.Department.class)
            .addAnnotatedClass(com.sumanezhumalai.Model.Project.class).configure().buildSessionFactory();

    static SessionFactory getSessionFactory() {
        return sf;
    }

    public static void closeResources() {
        sf.close();
    }
}
