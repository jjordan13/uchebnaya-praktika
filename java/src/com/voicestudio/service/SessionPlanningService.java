package com.voicestudio.service;

import com.voicestudio.model.AudioAsset;
import com.voicestudio.model.Casting;
import com.voicestudio.model.RecordingSession;

import java.util.*;

public class SessionPlanningService implements ISessionPlanner {
    private final List<Casting> castings;
    private final Map<Integer, Integer> characterToActorCache;

    public SessionPlanningService(List<Casting> castings) {
        this.castings = castings;
        this.characterToActorCache = buildCharacterToActorMap();
    }

    private Map<Integer, Integer> buildCharacterToActorMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for (Casting c : castings) {
            if (c.isApproved()) {
                map.put(c.getIdCharacter(), c.getIdActor());
            }
        }
        return map;
    }

    @Override
    public List<RecordingSession> planSessions(List<AudioAsset> assets,
            double maxSessionDurationSeconds) {
        // Шаг 1: Группировка ассетов по актёрам
        Map<Integer, List<AudioAsset>> actorAssets = new LinkedHashMap<>();
        for (AudioAsset asset : assets) {
            Integer actorId = characterToActorCache.get(asset.getIdCharacter());
            if (actorId != null) {
                actorAssets.computeIfAbsent(actorId, k -> new ArrayList<>()).add(asset);
            }
        }

        // Шаг 2: Жадное распределение по сессиям
        List<RecordingSession> sessions = new ArrayList<>();
        int sessionCounter = 1;

        for (Map.Entry<Integer, List<AudioAsset>> entry : actorAssets.entrySet()) {
            int actorId = entry.getKey();
            List<AudioAsset> actorAssetList = entry.getValue();

            RecordingSession currentSession = null;

            for (AudioAsset asset : actorAssetList) {
                double duration = asset.getDurationTarget();

                if (duration > maxSessionDurationSeconds) {
                    throw new IllegalArgumentException(
                            "Ассет " + asset.getId() + " длиннее максимальной сессии");
                }

                // Создаём новую сессию, если текущей нет или она переполнена
                if (currentSession == null ||
                        currentSession.getDurationSeconds() + duration > maxSessionDurationSeconds) {
                    currentSession = new RecordingSession(
                            sessionCounter++,
                            java.time.LocalDate.now().toString(),
                            asset.getIdProject(),
                            0, 0,
                            actorId);
                    sessions.add(currentSession);
                }

                currentSession.addAsset(asset.getId());
                currentSession.setDurationSeconds(
                        currentSession.getDurationSeconds() + duration);
                asset.setIdSession(currentSession.getId());
            }
        }

        return sessions;
    }
}