package com.voicestudio.model;

public class Bark extends AudioAsset {
    public Bark(int id, String originalText, String adaptedText,
                double durationTarget, int idProject, int idCharacter) {
        super(id, originalText, adaptedText, durationTarget, idProject, idCharacter);
    }

    @Override
    public String getAssetTypeName() { return "Боевой выкрик"; }

    @Override
    public boolean requiresLipSync() { return false; }
}