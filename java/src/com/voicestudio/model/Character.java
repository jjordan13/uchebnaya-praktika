package com.voicestudio.model;

public class Character {
    private int id;
    private String name;
    private String description;
    private int idProject;

    public Character(int id, String name, String description, int idProject) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idProject = idProject;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdProject() {
        return idProject;
    }
}