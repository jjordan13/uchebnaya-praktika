package com.voicestudio.model;

import com.voicestudio.model.enums.AssetStatus;

public abstract class AudioAsset {
    private int id;
    private String originalText;
    private String adaptedText;
    private double durationTarget;
    private String filePath;
    private AssetStatus status;
    private int idProject;
    private int idCharacter;
    private Integer idSession;

    public AudioAsset(int id, String originalText, String adaptedText, double durationTarget, int idProject,
            int idCharacter) {
        this.id = id;
        this.originalText = originalText;
        this.adaptedText = adaptedText;
        this.durationTarget = durationTarget;
        this.idProject = idProject;
        this.idCharacter = idCharacter;
        this.status = AssetStatus.WAITING;
    }

    public int getId() {
        return id;
    }

    public String getOriginalText() {
        return originalText;
    }

    public String getAdaptedText() {
        return adaptedText;
    }

    public double getDurationTarget() {
        return durationTarget;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public AssetStatus getStatus() {
        return status;
    }

    public void setStatus(AssetStatus status) {
        this.status = status;
    }

    public int getIdProject() {
        return idProject;
    }

    public int getIdCharacter() {
        return idCharacter;
    }

    public Integer getIdSession() {
        return idSession;
    }

    public void setIdSession(Integer idSession) {
        this.idSession = idSession;
    }

    public abstract String getAssetTypeName();

    public abstract boolean requiresLipSync();
}