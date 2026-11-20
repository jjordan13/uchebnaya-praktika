package com.voicestudio.model;

public class Project {
    private int id;
    private String title;
    private String developer;
    private String startDate;
    private String deadline;
    private double budget;

    public Project(int id, String title, String developer,
            String startDate, String deadline, double budget) {
        this.id = id;
        this.title = title;
        this.developer = developer;
        this.startDate = startDate;
        this.deadline = deadline;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}