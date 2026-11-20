package com.voicestudio.model;

import java.util.ArrayList;
import java.util.List;

public class RecordingSession {
    private int id;
    private String sessionDate;
    private double durationSeconds;
    private String studioRoom;
    private int idProject;
    private int idDirector;
    private int idEngineer;
    private int idActor; // ключевое поле — сессия привязана к одному актёру
    private List<Integer> assetIds;

    public RecordingSession(int id, String sessionDate, int idProject,
            int idDirector, int idEngineer, int idActor) {
        this.id = id;
        this.sessionDate = sessionDate;
        this.idProject = idProject;
        this.idDirector = idDirector;
        this.idEngineer = idEngineer;
        this.idActor = idActor;
        this.assetIds = new ArrayList<>();
        this.durationSeconds = 0;
    }

    public int getId() {
        return id;
    }

    public int getIdActor() {
        return idActor;
    }

    public List<Integer> getAssetIds() {
        return assetIds;
    }

    public double getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(double durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public void addAsset(int assetId) {
        assetIds.add(assetId);
    }
}