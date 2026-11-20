package com.voicestudio.model;

import java.util.HashSet;
import java.util.Set;

public class Actor {
    private int id;
    private String fullName;
    private String contactInfo;
    private String demoReelUrl;
    private double hourlyRate;
    private boolean isAvailable;
    private Set<Integer> tagIds;

    public Actor(int id, String fullName, String contactInfo,
            String demoReelUrl, double hourlyRate, boolean isAvailable) {
        this.id = id;
        this.fullName = fullName;
        this.contactInfo = contactInfo;
        this.demoReelUrl = demoReelUrl;
        this.hourlyRate = hourlyRate;
        this.isAvailable = isAvailable;
        this.tagIds = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDemoReelUrl() {
        return demoReelUrl;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Set<Integer> getTagIds() {
        return tagIds;
    }

    public void addTag(int tagId) {
        tagIds.add(tagId);
    }
}