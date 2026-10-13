package com.sumanezhumalai.concept;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sumanezhumalai.Model.Employee;

public class EHcache {
    public static void EHcacheConcept() {
        Relations seed = new Relations(); // this runs the Relation Constructor and seed Tables:
        System.out.println(seed.getClass() + " -> Callinfg to Seed data");

        SessionFactory sf = Configurations.getSessionFactory();

        // L2 (Ehcache via JCache): shared across Sessions.
        // Expectation: 1st find() hits DB + fills L2, 2nd find() of same id serves from
        // L2 (no employees SELECT).
        // Proof below is Statistics (hits/misses), not just eyeballing SQL —
        // SQL still shows Department/Device SELECTs unless those entities are cached
        // too.

        System.out.println("\n\n");

        try (Session session1 = sf.openSession()) {
            Employee employee = session1.find(Employee.class, 1);
            // System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Same row in two different Sessions: 2x SELECT = L2 miss, 1x (first only) = L2
        // hit.

        // NOTE -> L2 needs (all three): provider jars in pom.xml (ehcache +
        // hibernate-jcache),
        // cfg props (use_second_level_cache + region.factory_class + jcache.provider),
        // and @Cacheable + @Cache(usage=...) on each entity you want cached.

        try (Session session2 = sf.openSession()) {
            Employee employee = session2.find(Employee.class, 1);
            // System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Objective proof: second-level hit count must be > 0 (needs
        // hibernate.generate_statistics=true).
        var stats = sf.getStatistics();
        System.out.println("L2 hits=" + stats.getSecondLevelCacheHitCount()
                + ", misses=" + stats.getSecondLevelCacheMissCount()
                + ", puts=" + stats.getSecondLevelCachePutCount());
    }
}
