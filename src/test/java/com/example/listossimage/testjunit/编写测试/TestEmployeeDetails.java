package com.example.listossimage.testjunit.编写测试;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployeeDetails {

    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
    EmployeeDetails employeeDetails = new EmployeeDetails();

    @Test
    public void testCalculateAppraisal() {
        employeeDetails.setName("小李");
        employeeDetails.setAge(21);
        employeeDetails.setMonthlySalary(8000);
        double appraisal = empBusinessLogic.calculateAppraisal(employeeDetails);
    }

    @Test
    public void testCalculateYearSalary() {
        employeeDetails.setName("小红");
        employeeDetails.setAge(23);
        employeeDetails.setMonthlySalary(8000);

        double salary = empBusinessLogic.calculateYearlySalary(employeeDetails);

        assertEquals(96000, salary, 0.0);
    }

}
