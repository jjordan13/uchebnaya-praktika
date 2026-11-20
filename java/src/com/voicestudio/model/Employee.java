package com.voicestudio.model;

public abstract class Employee {
    private int id;
    private String fullName;
    private String email;
    private String role;

    public Employee(int id, String fullName, String email, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    public abstract String describeResponsibilities();
}