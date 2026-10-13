package com.sumanezhumalai.concept;

import com.sumanezhumalai.Model.Computer;
import com.sumanezhumalai.Model.Device;
import com.sumanezhumalai.Model.Employee;
import com.sumanezhumalai.operations.DepartmentOperation;
import com.sumanezhumalai.operations.DeviceOperation;
import com.sumanezhumalai.operations.EmployeeOperation;

public class Basic {
    public static void basicConcept() {

        Relations obj = new Relations();

        // GetOperationObjects----------
        DeviceOperation deviceOp = obj.getDeviceOp();
        EmployeeOperation employeeOp = obj.getEmployeeOp();
        DepartmentOperation departmentOp = obj.getDepartmentOp();

        // ----- employee operations

        // update
        employeeOp.UpdateEmployee(
                new Employee(1, "Shyam", 23, null, departmentOp.getDepartmentById(1), deviceOp.getDeviceById(1)));

        // get
        System.out.println(employeeOp.getEmployeeById(2));

        // delete
        employeeOp.deleteEmployee(5);

        // Fetch ALl
        employeeOp.getAllEmployees().forEach(employee -> System.out.println(employee));

        // ----- DeviceOperation

        // update
        deviceOp.UpdateDevice(new Device(2, Computer.Desktop, "Development,Design, Video Editing"));

        // get by Id
        System.out.println(deviceOp.getDeviceById(1));

        // Fetch ALl
        deviceOp.getAllDevices().forEach(device -> System.out.println(device));
        // -----

    }
}
