package com.sumanezhumalai.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import com.sumanezhumalai.Model.Department;

public class DepartmentOperation {
    private SessionFactory sf;

    public DepartmentOperation(SessionFactory sf) {
        this.sf = sf;
    }

    // ---------------

    // Insert
    public void addNewDepartment(Department department) {
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();

            session.persist(department);
            transaction.commit();

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("the " + department + "already exists !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update a Department (find and update)
    public void UpdateDepartment(Department department) {
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();

            session.merge(department);
            transaction.commit();

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("the " + department + "already exists !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get a Specific Department (searchbyId)
    public Department getDepartmentById(int id) {

        try (Session session = sf.openSession();) {

            return session.find(Department.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Department(0, null, null);
    }

    // Delete a Department (find and delete)
    public void deleteDepartment(int id) {
        try (Session session = sf.openSession();) {

            Transaction transaction = session.beginTransaction();
            Department department = session.find(Department.class, id);

            session.remove(department);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch All
    public List<Department> getAllDepartments() {

        try (Session session = sf.openSession();) {

            // HQL
            return session.createQuery("FROM Department", Department.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
