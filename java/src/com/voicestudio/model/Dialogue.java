package com.voicestudio.model;

public class Dialogue extends AudioAsset {
    public Dialogue(int id, String originalText, String adaptedText,
                    double durationTarget, int idProject, int idCharacter) {
        super(id, originalText, adaptedText, durationTarget, idProject, idCharacter);
    }

    @Override
    public String getAssetTypeName() { return "Диалог"; }

    @Override
    public boolean requiresLipSync() { return true; }
}