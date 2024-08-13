package com.example.employeemanagementsystem.projection;

public class DepartmentProjection {

    private final String name;
    private final int employeeCount;

    public DepartmentProjection(String name, int employeeCount) {
        this.name = name;
        this.employeeCount = employeeCount;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }
}
