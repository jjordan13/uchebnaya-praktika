package com.voicestudio.service;

import com.voicestudio.model.AudioAsset;
import com.voicestudio.model.RecordingSession;
import java.util.List;

public interface ISessionPlanner {
    List<RecordingSession> planSessions(List<AudioAsset> assets, double maxSessionDurationSeconds);
}