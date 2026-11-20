package com.voicestudio.model;

public class Tag {
    private int id;
    private String tagName;
    private String tagCategory;

    public Tag(int id, String tagName, String tagCategory) {
        this.id = id;
        this.tagName = tagName;
        this.tagCategory = tagCategory;
    }

    public int getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public String getTagCategory() {
        return tagCategory;
    }
}