package com.voicestudio.model.enums;

public enum AssetStatus {
    WAITING("Ожидает"),
    RECORDED("Записано"),
    REJECTED("Брак"),
    MIXED("Сведено"),
    QA_APPROVED("QA пройдено"),
    READY("Готово");

    private final String displayName;

    AssetStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() { return displayName; }
}