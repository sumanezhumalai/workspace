package com.sumanezhumalai.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sumanezhumalai.Model.Device;

public class DeviceOperation {
    private SessionFactory sf;

    public DeviceOperation(SessionFactory sf) {
        this.sf = sf;
    }

    // ---------------

    // Insert
    public void addNewDevice(Device device) { // insert need transaction to commity changes of the session to Database
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();

            session.persist(device);
            transaction.commit();

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("the " + device + "already exists !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update a Device (find and update)
    public void UpdateDevice(Device device) {
        try (Session session = sf.openSession();) {
            Transaction transaction = session.beginTransaction();

            session.merge(device);
            transaction.commit();

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("the " + device + "already exists !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get a Specific Device (searchbyId)
    public Device getDeviceById(int id) { // Get or retrievel does'nt need transaction

        try (Session session = sf.openSession();) {

            return session.find(Device.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Device(0, null, null);
    }

    // Delete a Device (find and delete)
    public void deleteDevice(int id) {
        try (Session session = sf.openSession();) {

            Transaction transaction = session.beginTransaction();
            Device device = session.find(Device.class, id); // deprcated but know , instead use
            // session.get(Device.class, id);

            session.remove(device);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch All
    public List<Device> getAllDevices() {

        try (Session session = sf.openSession();) {

            return session.createQuery("FROM Device", Device.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
