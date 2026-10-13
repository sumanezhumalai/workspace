package com.sumanezhumalai.Model;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
// import jakarta.persistence.Transient;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Device {

    @Id
    int id;
    // @Transient //Hibernate will skip this column while creating table
    Computer type;
    @Column(name = "operation")
    String task;

    public Device() {
    }

    @Override
    public String toString() {
        return "Device [id=" + id + ", type=" + type + ", task=" + task + "]";
    }

    public Device(int id, Computer type, String task) {
        this.id = id;
        this.type = type;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Computer getType() {
        return type;
    }

    public void setType(Computer type) {
        this.type = type;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}
