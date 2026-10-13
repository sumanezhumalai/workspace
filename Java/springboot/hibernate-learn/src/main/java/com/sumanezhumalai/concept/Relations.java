package com.sumanezhumalai.concept;

import java.util.List;

import org.hibernate.SessionFactory;

import com.sumanezhumalai.Model.Address;
import com.sumanezhumalai.Model.Computer;
import com.sumanezhumalai.Model.Department;
import com.sumanezhumalai.Model.Device;
import com.sumanezhumalai.Model.Employee;
import com.sumanezhumalai.Model.Project;
import com.sumanezhumalai.operations.DepartmentOperation;
import com.sumanezhumalai.operations.DeviceOperation;
import com.sumanezhumalai.operations.EmployeeOperation;
import com.sumanezhumalai.operations.ProjectOperation;

import java.util.ArrayList;

public class Relations {
    // this class depict how Defenition of Entities Relations with @OneToOne
    // @OneToMany @ManyToMany
    // with or wothout (mappedBuy="OtherTables'Column")

    // Checkout the Database tables view manually on each run TO understand the
    // table formation by Relation and Hubernate Annotation

    private SessionFactory sf = Configurations.getSessionFactory();

    private DeviceOperation deviceOp = new DeviceOperation(sf);
    private EmployeeOperation employeeOp = new EmployeeOperation(sf);
    private DepartmentOperation departmentOp = new DepartmentOperation(sf);
    private ProjectOperation projectOp = new ProjectOperation(sf);

    public DeviceOperation getDeviceOp() {
        return deviceOp;
    }

    public EmployeeOperation getEmployeeOp() {
        return employeeOp;
    }

    public DepartmentOperation getDepartmentOp() {
        return departmentOp;
    }

    public ProjectOperation getProjectOp() {
        return projectOp;
    }

    // Populate ----------

    // OneToOne -> Device <-> Employee
    Relations() {
        List<Device> devices = List.of(
                new Device(1, Computer.Laptop, "Development, Testing"),
                new Device(2, Computer.Desktop, "Design, Video Editing"),
                new Device(3, Computer.MacBook, "iOS Development"),
                new Device(4, Computer.Remote, "Cloud Deployment"),
                new Device(5, Computer.Server, "Database Hosting"));

        // insert (persist)
        devices.forEach(deviceOp::addNewDevice);

        // OneToMany -> Department <-> Employee
        List<Department> depts = List.of(
                new Department(1, "Engineering", null),
                new Department(2, "HR", null),
                new Department(3, "Support", null));
        depts.forEach(departmentOp::addNewDepartment);

        // ManyToOne -> Employee <-> Department
        // OneToOne -> Employee <-> Device
        List<Employee> employees = List.of(
                new Employee(1, "Suman", 22, new Address("Abimanyu Nagar", "Kalapet", "Puducherry"), depts.get(0),
                        devices.get(0)),
                new Employee(2, "Ramulan", 24, new Address("Gandhi Street", "Kalapet", "Puducherry"), depts.get(1),
                        devices.get(1)),
                new Employee(3, "Priya", 22, new Address("Nehru Street", "Lawspet", "Puducherry"), depts.get(0),
                        devices.get(2)),
                new Employee(4, "Karthik", 25, new Address("Anna Nagar", "Villianur", "Puducherry"), depts.get(2),
                        devices.get(3)),
                new Employee(5, "Divya", 21,
                        new Address("Kamaraj Nagar", "Ariyankuppam", "Puducherry"), depts.get(2), devices.get(4)));

        // insert (persist)
        employees.forEach(employeeOp::addNewEmployee);

        depts.forEach(dept -> dept.setEmployee(employeeOp.getEmployeesByDepartment(dept.getId())));

        // ManyToMany -> Project <-> Employee (Project owns the join table)
        List<Project> projects = List.of(
                new Project(1, "Billing System", "Development, Testing", null),
                new Project(2, "Design Portal", "Design, Video Editing", null),
                new Project(3, "Cloud Migration", "Deployment, Support", null));
        projects.forEach(projectOp::addNewProject);

        // link owning side, then merge to write join-table rows
        projects.get(0).setEmployees(new ArrayList<>(List.of(employees.get(0), employees.get(1), employees.get(2))));
        projects.get(1).setEmployees(new ArrayList<>(List.of(employees.get(1), employees.get(3))));
        projects.get(2).setEmployees(new ArrayList<>(List.of(employees.get(2), employees.get(3), employees.get(4))));
        projects.forEach(projectOp::UpdateProject);

        // inverse side, in-memory only (for toString / inspection)
        employees.get(0).setProjects(new ArrayList<>(List.of(projects.get(0))));
        employees.get(1).setProjects(new ArrayList<>(List.of(projects.get(0), projects.get(1))));
        employees.get(2).setProjects(new ArrayList<>(List.of(projects.get(0), projects.get(2))));
        employees.get(3).setProjects(new ArrayList<>(List.of(projects.get(1), projects.get(2))));
        employees.get(4).setProjects(new ArrayList<>(List.of(projects.get(2))));
    }

}
