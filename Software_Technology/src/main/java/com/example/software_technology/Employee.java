package com.example.software_technology;

public class Employee {

    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private double salary;

    public Employee(int employeeID, String firstName, String lastName, String email, String password, double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }
}

