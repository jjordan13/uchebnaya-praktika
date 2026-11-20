package com.voicestudio.model;

public class Translator extends Employee {
    private String sourceLanguage;
    private String targetLanguage;

    public Translator(int id, String fullName, String email,
                      String sourceLanguage, String targetLanguage) {
        super(id, fullName, email, "Переводчик-адаптер");
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
    }

    @Override
    public String describeResponsibilities() {
        return "Литературная адаптация текста с " + sourceLanguage +
                " на " + targetLanguage + " с учётом липсинка";
    }
}