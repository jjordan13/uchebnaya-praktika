package com.voicestudio;

import com.voicestudio.model.*;
import com.voicestudio.model.enums.*;
import com.voicestudio.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Студия озвучивания игр: Java-реализация ===\n");

        // Подготовка тестовых данных
        Map<Integer, Tag> tags = new HashMap<>();
        tags.put(1, new Tag(1, "мужской", "пол"));
        tags.put(2, new Tag(2, "женский", "пол"));
        tags.put(3, new Tag(3, "низкий тембр", "тембр"));
        tags.put(4, new Tag(4, "высокий тембр", "тембр"));
        tags.put(5, new Tag(5, "возраст 40-50", "возраст"));
        tags.put(6, new Tag(6, "агрессивный", "стиль"));
        tags.put(7, new Tag(7, "спокойный", "стиль"));

        Map<Integer, Actor> actors = new HashMap<>();
        Actor a1 = new Actor(1, "Иванов И.И.", "ivanov@mail.ru", "demo1.mp3", 5000, true);
        a1.addTag(1);
        a1.addTag(3);
        a1.addTag(5);
        a1.addTag(6);
        actors.put(1, a1);

        Actor a2 = new Actor(2, "Петров П.П.", "petrov@mail.ru", "demo2.mp3", 6000, true);
        a2.addTag(1);
        a2.addTag(3);
        a2.addTag(5);
        actors.put(2, a2);

        Actor a3 = new Actor(3, "Сидорова А.А.", "sidorova@mail.ru", "demo3.mp3", 5500, true);
        a3.addTag(2);
        a3.addTag(4);
        a3.addTag(7);
        actors.put(3, a3);

        Actor a4 = new Actor(4, "Козлов К.К.", "kozlov@mail.ru", "demo4.mp3", 7000, true);
        a4.addTag(1);
        a4.addTag(3);
        a4.addTag(6);
        actors.put(4, a4);

        // ТЕСТ 1: Алгоритм кастинга
        System.out.println("--- Тест 1: Поиск актёров по тегам ---");
        IActorSearcher searcher = new ActorSearchService(actors, tags);
        List<Actor> found = searcher.searchByTags(Arrays.asList("мужской", "низкий тембр"));
        for (int i = 0; i < found.size(); i++) {
            Actor actor = found.get(i);
            System.out.printf("%d. %s | Демо: %s | Ставка: %.0f руб./час%n",
                    i + 1, actor.getFullName(), actor.getDemoReelUrl(), actor.getHourlyRate());
        }

        // Подготовка данных для sheeting
        List<AudioAsset> assets = new ArrayList<>();
        assets.add(new Dialogue(1, "Hello, warrior!", "Привет, воин!", 2.5, 1, 1));
        assets.add(new Dialogue(2, "You shall not pass!", "Тебе не пройти!", 3.0, 1, 2));
        assets.add(new Dialogue(3, "Welcome, hero!", "Добро пожаловать, герой!", 2.0, 1, 1));
        assets.add(new Bark(4, "Take this!", "Получай!", 1.5, 1, 2));
        assets.add(new Dialogue(5, "Thank you!", "Спасибо!", 1.8, 1, 3));

        List<Casting> castings = Arrays.asList(
                new Casting(1, 1, true, "2026-09-01"),
                new Casting(2, 1, false, "2026-09-01"),
                new Casting(4, 2, true, "2026-09-02"),
                new Casting(3, 3, true, "2026-09-03"));

        // ТЕСТ 2: Алгоритм sheeting
        System.out.println("\n--- Тест 2: Распределение реплик по сессиям ---");
        ISessionPlanner planner = new SessionPlanningService(castings);
        List<RecordingSession> sessions = planner.planSessions(assets, 10.0);
        for (RecordingSession s : sessions) {
            System.out.printf("Сессия %d | Актёр ID: %d | Реплики: %s | Длительность: %.1f сек.%n",
                    s.getId(), s.getIdActor(), s.getAssetIds(), s.getDurationSeconds());
        }
    }
}