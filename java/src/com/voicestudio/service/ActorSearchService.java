package com.voicestudio.service;

import com.voicestudio.model.Actor;
import com.voicestudio.model.Tag;

import java.util.*;

public class ActorSearchService implements IActorSearcher {
    private final Map<Integer, Actor> actors;
    private final Map<Integer, Tag> tags;

    public ActorSearchService(Map<Integer, Actor> actors, Map<Integer, Tag> tags) {
        this.actors = actors;
        this.tags = tags;
    }

    @Override
    public List<Actor> searchByTags(List<String> tagNames) {
        // Шаг 1: Извлечь ID запрошенных тегов
        Set<Integer> requestedTagIds = new HashSet<>();
        for (Tag tag : tags.values()) {
            if (tagNames.contains(tag.getTagName())) {
                requestedTagIds.add(tag.getId());
            }
        }

        if (requestedTagIds.isEmpty()) {
            return new ArrayList<>();
        }

        // Шаг 2: Фильтрация актёров
        List<ActorMatch> matches = new ArrayList<>();
        for (Actor actor : actors.values()) {
            Set<Integer> actorTagIds = actor.getTagIds();
            if (actorTagIds.containsAll(requestedTagIds)) {
                int rating = actorTagIds.size() - requestedTagIds.size();
                matches.add(new ActorMatch(actor, rating));
            }
        }

        // Шаг 3: Сортировка по убыванию рейтинга
        matches.sort(Comparator.comparingInt(ActorMatch::getRating).reversed());

        // Шаг 4: Извлечение актёров
        List<Actor> result = new ArrayList<>();
        for (ActorMatch match : matches) {
            result.add(match.getActor());
        }
        return result;
    }

    private static class ActorMatch {
        private final Actor actor;
        private final int rating;

        public ActorMatch(Actor actor, int rating) {
            this.actor = actor;
            this.rating = rating;
        }

        public Actor getActor() {
            return actor;
        }

        public int getRating() {
            return rating;
        }
    }
}