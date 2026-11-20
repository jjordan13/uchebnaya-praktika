package com.voicestudio.model;

public class SoundEngineer extends Employee {
    private String dawSoftware;

    public SoundEngineer(int id, String fullName, String email, String dawSoftware) {
        super(id, fullName, email, "Звукоинженер");
        this.dawSoftware = dawSoftware;
    }

    @Override
    public String describeResponsibilities() {
        return "Запись, чистка, синхронизация и мастеринг аудио в " + dawSoftware;
    }
}