package com.todo.demo;

public class Employee {
    private int id;
    private int employeeId;
    private String fName;

    public Employee(int id, int employeeId, String fName, String lName, int departmentId) {
        this.id = id;
        this.employeeId = employeeId;
        this.fName = fName;
        this.lName = lName;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    private String lName;
    private int departmentId;

}
