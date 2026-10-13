package com.sumanezhumalai.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import com.sumanezhumalai.Model.Project;

public class ProjectOperation {
    private SessionFactory sf;

    public ProjectOperation(SessionFactory sf) {
        this.sf = sf;
    }

    // ---------------

    // Insert
    public void addNewProject(Project project) {
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();

            session.persist(project);
            transaction.commit();

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("the " + project + "already exists !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update a Project (find and update)
    public void UpdateProject(Project project) {
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();

            session.merge(project);
            transaction.commit();

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("the " + project + "already exists !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get a Specific Project (searchbyId)
    public Project getProjectById(int id) {

        try (Session session = sf.openSession();) {

            return session.find(Project.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Project(0, null, null, null);
    }

    // Delete a Project (find and delete)
    public void deleteProject(int id) {
        try (Session session = sf.openSession();) {

            Transaction transaction = session.beginTransaction();
            Project project = session.find(Project.class, id);

            session.remove(project);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch All
    public List<Project> getAllProjects() {

        try (Session session = sf.openSession();) {

            return session.createQuery("FROM Project", Project.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
