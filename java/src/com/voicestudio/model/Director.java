package com.voicestudio.model;

public class Director extends Employee {
    private double hourlyRate;

    public Director(int id, String fullName, String email, double hourlyRate) {
        super(id, fullName, email, "Режиссёр дубляжа");
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String describeResponsibilities() {
        return "Проведение кастинга, распределение ролей, руководство студийными сессиями";
    }

    public double getHourlyRate() { return hourlyRate; }
}