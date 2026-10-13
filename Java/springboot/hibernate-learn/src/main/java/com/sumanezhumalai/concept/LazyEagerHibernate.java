package com.sumanezhumalai.concept;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sumanezhumalai.Model.Employee;

public class LazyEagerHibernate {
    public static void LazyEagerHibernateConcept() {

        SessionFactory sf = Configurations.getSessionFactory();

        // Hibernate cache = avoids DB hit on every find().
        // L1 (default, mandatory): Session-scoped. Same Session + same id -> no SELECT,
        // same Java instance.
        // L2 (opt-in, shared): SessionFactory-scoped, shared across Sessions. Needs
        // provider (Caffeine/EHCache) + @Cacheable.
        // Fetch (orthogonal to cache): @ManyToOne/@OneToOne default EAGER,
        // @OneToMany/@ManyToMany default LAZY.

        // Session 1 - L1 hit demo

        Employee employee = new Employee(0, "Suman", 10, null, null, null);

        try (Session session = sf.openSession();) { // auto closes session
            Transaction transaction = session.beginTransaction();

            session.persist(employee); // operation 1 persist() - will be executed
            transaction.commit();

            int id = employee.getId();
            Employee fetchedEmployee = session.find(Employee.class, id); // operation 2 fetch - will not be executed in
                                                                         // the same session1
            System.out.println(fetchedEmployee);

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("the " + employee + "already exists !");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Session 2 - new Session = empty L1, so SELECT fires. LAZY: projects
        // (ManyToMany) loads only on access.
        int id = employee.getId();
        try (Session session2 = sf.openSession();) { // auto closes session
            Employee fetchedEmployee = session2.find(Employee.class, id); // operation 2 fetch - will be executed (it
                                                                          // has its own session)
            System.out.println(fetchedEmployee);
            // LAZY so projects NOT fetched here; use fetch = FetchType.EAGER or access
            // getProjects() inside session to load it.

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Summary: L1 = per-Session default (this demo). L2 = cross-Session opt-in via
        // Caffeine/EHCache + @Cacheable.
    }
}
