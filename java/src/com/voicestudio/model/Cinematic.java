package com.voicestudio.model;

public class Cinematic extends AudioAsset {
    public Cinematic(int id, String originalText, String adaptedText,
            double durationTarget, int idProject, int idCharacter) {
        super(id, originalText, adaptedText, durationTarget, idProject, idCharacter);
    }

    @Override
    public String getAssetTypeName() {
        return "Катсцена";
    }

    @Override
    public boolean requiresLipSync() {
        return true;
    }
}