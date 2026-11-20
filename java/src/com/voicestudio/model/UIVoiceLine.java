package com.voicestudio.model;

public class UIVoiceLine extends AudioAsset {
    public UIVoiceLine(int id, String originalText, String adaptedText,
            double durationTarget, int idProject, int idCharacter) {
        super(id, originalText, adaptedText, durationTarget, idProject, idCharacter);
    }

    @Override
    public String getAssetTypeName() {
        return "UI-подсказка";
    }

    @Override
    public boolean requiresLipSync() {
        return false;
    }
}