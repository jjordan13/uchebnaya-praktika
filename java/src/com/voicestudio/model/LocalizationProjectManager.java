package com.voicestudio.model;

public class LocalizationProjectManager extends Employee {
    public LocalizationProjectManager(int id, String fullName, String email) {
        super(id, fullName, email, "LPM");
    }

    @Override
    public String describeResponsibilities() {
        return "Координация сроков, бюджетов и коммуникации с заказчиком";
    }
}