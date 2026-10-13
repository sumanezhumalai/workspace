package com.sumanezhumalai.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import com.sumanezhumalai.Model.Employee;

public class EmployeeOperation {
    private SessionFactory sf;

    public EmployeeOperation(SessionFactory sf) {
        this.sf = sf;
    }

    // ---------------

    // Insert
    public void addNewEmployee(Employee employee) { // insert need transaction to commity changes of the session to
                                                    // Database
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();

            session.persist(employee);
            transaction.commit();

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("the " + employee + "already exists !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update a Employee (find and update)
    public void UpdateEmployee(Employee employee) {
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();

            session.merge(employee);
            transaction.commit();

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("the " + employee + "already exists !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get a Specific Employee (searchbyId)
    public Employee getEmployeeById(int id) { // Get or retrievel does'nt need transaction

        try (Session session = sf.openSession();) {

            return session.find(Employee.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Employee(0, null, 0, null, null, null);
    }

    // Update a Employee (find and update)
    public void deleteEmployee(int id) {
        try (Session session = sf.openSession();) {

            Transaction transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class, id); // deprcated but know , instead use
            // session.get(Employee.class, id);

            session.remove(employee);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch All Employee By Department
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        String hql = "FROM Employee e WHERE e.department.id = :deptId";

        try (Session session = sf.openSession()) {
            return session.createQuery(hql, Employee.class)
                    .setParameter("deptId", departmentId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    // Fetch All
    public List<Employee> getAllEmployees() {

        try (Session session = sf.openSession();) {

            return session.createQuery("FROM Employee", Employee.class).getResultList();
            // NOTE ! createQuery() is deprecated in modern Hibernate
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
