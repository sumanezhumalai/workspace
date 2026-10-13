package com.sumanezhumalai.concept;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sumanezhumalai.Model.Department;
import com.sumanezhumalai.Model.Employee;
import com.sumanezhumalai.operations.DepartmentOperation;

public class HqlQuery {
    public static void hqlQueryConcept() {
        Relations seed = new Relations(); // this runs the Relation Constructor and seed Tables:
        System.out.println(seed.getClass() + " -> Callinfg to Seed data");

        SessionFactory sf = Configurations.getSessionFactory();

        System.out.println("\n\n");

        // HQL -> EAGER LOAD
        String queryHQL = "from Employee where age = 22";

        try (Session session = sf.openSession()) {
            Query<Employee> query = session.createQuery(queryHQL, Employee.class); // createQuery(String queryString)
                                                                                   // Deprecated
            // also Query is a raw type. References to generic type Query<R> should be
            // parameterized

            List<Employee> employees = query.getResultList(); // return as list straight
            employees.forEach(e -> System.out.println(e.toString()));
        }

        System.out.println("\n\n");

        // Fetching by HQL (parameterized way) - EAGER LOAD

        DepartmentOperation departmentOp = seed.getDepartmentOp();
        Department department = departmentOp.getDepartmentById(0);

        try (Session session = sf.openSession()) {
            Query<String> query = session.createQuery("Select name from Employee where department = ?1",
                    String.class);
            // createQuery(String queryString) Deprecated
            // also Query is a raw type. References to generic type Query<R> should be
            // parameterized

            query.setParameter(1, department);
            List<String> employees = query.getResultList(); // return as list straight

            employees.forEach(e -> System.out.println(e.toString()));
        }

        System.out.println("\n\n");

        // Fetching by HQL (parameterized way) - Specific Columns
        // As list straight<Object[]> - to treat each column value as object and type
        // cast it

        int employeeAge = 22;

        try (Session session = sf.openSession()) {
            Query<Object[]> query = session.createQuery("Select name,age from Employee where age = ?1", Object[].class);
            // getting as Object since we are sleecting specific rows (no DTOs)
            // createQuery(String queryString) Deprecated
            // also Query is a raw type. References to generic type Query<R> should be
            // parameterized

            query.setParameter(1, employeeAge);

            List<Object[]> employees = query.getResultList();
            // return as list straight<Object[]> - to treat each column value as object
            // and type cast it

            employees.forEach(e -> System.out.println("Name : " + e[0] + " , Age : " +
                    e[1]));

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n\n");

        // // Selective column load via DTO constructor expression.
        // // HQL `new` needs the FQCN of a top-level (or static nested) class +
        // matching
        // // ctor.
        // try (Session session = sf.openSession()) {
        // // Inside session:
        // Query<EmployeeDTO> query = session.createQuery(
        // "SELECT new com.sumanezhumalai.concept.EmployeeDTO(e.name, e.age) FROM
        // Employee e WHERE e.age = ?1",
        // EmployeeDTO.class);

        // query.setParameter(1, employeeAge);
        // List<EmployeeDTO> employees = query.getResultList();

        // employees.forEach(e -> System.out.println("Name: " + e.name() + ", Age: " +
        // e.age()));
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

    }
}
