package com.voicestudio.model;

public class Casting {
    private int idActor;
    private int idCharacter;
    private boolean isApproved;
    private String auditionDate;

    public Casting(int idActor, int idCharacter, boolean isApproved, String auditionDate) {
        this.idActor = idActor;
        this.idCharacter = idCharacter;
        this.isApproved = isApproved;
        this.auditionDate = auditionDate;
    }

    public int getIdActor() {
        return idActor;
    }

    public int getIdCharacter() {
        return idCharacter;
    }

    public boolean isApproved() {
        return isApproved;
    }
}