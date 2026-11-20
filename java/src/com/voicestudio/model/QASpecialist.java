package com.voicestudio.model;

public class QASpecialist extends Employee {
    public QASpecialist(int id, String fullName, String email) {
        super(id, fullName, email, "QA-специалист");
    }

    @Override
    public String describeResponsibilities() {
        return "Финальная проверка ассетов в контексте игры (in-game testing)";
    }
}