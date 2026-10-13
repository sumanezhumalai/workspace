package com.sumanezhumalai.concept;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sumanezhumalai.Model.Employee;

public class GetVsLoad {
    public static void getVsLoadConcept() {
        Relations seed = new Relations(); // this runs the Relation Constructor and seed Tables:
        System.out.println(seed.getClass() + " -> Callinfg to Seed data");

        SessionFactory sf = Configurations.getSessionFactory();

        System.out.println("\n");

        System.out.println("\n GET or FIND - EagerFetch\n");
        int id = 1;

        try (Session session = sf.openSession()) {
            // session.get(Employee.class, id); //OR
            Employee employee = session.find(Employee.class, id);

            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get data - EAGER LOAD

        // Load data - LAZY LOAD
        System.out.println("\n Load - LazyFetch\n");
        try (Session session = sf.openSession()) {
            // Employee employee = session.load(Employee.class, id); // -> Deprectated
            // cannot be used

            Employee employee = session.getReference(Employee.class, 2);
            // Hibernate wont load or even create the query (while using load or
            // .getReference))
            // it wont load or generate query to get/find/load the data until i
            // call to save it as below

            System.out.println(employee.getName() + " " + employee.getAge());
            // try out by commenting and uncommenting the above usage print statement
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
