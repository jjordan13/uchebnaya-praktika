# Тестовые данные, имитирующие таблицы базы данных

tags = {
    1: {"tag_name": "мужской", "tag_category": "пол"},
    2: {"tag_name": "женский", "tag_category": "пол"},
    3: {"tag_name": "низкий тембр", "tag_category": "тембр"},
    4: {"tag_name": "высокий тембр", "tag_category": "тембр"},
    5: {"tag_name": "возраст 40-50", "tag_category": "возраст"},
    6: {"tag_name": "агрессивный", "tag_category": "стиль"},
    7: {"tag_name": "спокойный", "tag_category": "стиль"},
}

actors = {
    1: {"full_name": "Иванов И.И.", "demo_reel_url": "demo1.mp3", "hourly_rate": 5000},
    2: {"full_name": "Петров П.П.", "demo_reel_url": "demo2.mp3", "hourly_rate": 6000},
    3: {"full_name": "Сидорова А.А.", "demo_reel_url": "demo3.mp3", "hourly_rate": 5500},
    4: {"full_name": "Козлов К.К.", "demo_reel_url": "demo4.mp3", "hourly_rate": 7000},
}

actor_tags = {
    1: {1, 3, 5, 6},
    2: {1, 3, 5},
    3: {2, 4, 7},
    4: {1, 3, 6},
}

characters = {
    1: {"name": "Главный герой", "description": "Мужчина 45 лет, воин", "id_project": 1},
    2: {"name": "Антагонист", "description": "Мужчина 50 лет, злодей", "id_project": 1},
    3: {"name": "Принцесса", "description": "Женщина 25 лет", "id_project": 1},
}

casting = {
    (1, 1): {"is_approved": True},
    (2, 1): {"is_approved": False},
    (4, 2): {"is_approved": True},
    (3, 3): {"is_approved": True},
}

audio_assets = {
    1: {"asset_type": "диалог", "original_text": "Hello, warrior!", "adapted_text": "Привет, воин!", "duration_target": 2.5, "id_project": 1, "id_character": 1},
    2: {"asset_type": "диалог", "original_text": "You shall not pass!", "adapted_text": "Тебе не пройти!", "duration_target": 3.0, "id_project": 1, "id_character": 2},
    3: {"asset_type": "диалог", "original_text": "Welcome, hero!", "adapted_text": "Добро пожаловать, герой!", "duration_target": 2.0, "id_project": 1, "id_character": 1},
    4: {"asset_type": "барк", "original_text": "Take this!", "adapted_text": "Получай!", "duration_target": 1.5, "id_project": 1, "id_character": 2},
    5: {"asset_type": "диалог", "original_text": "Thank you!", "adapted_text": "Спасибо!", "duration_target": 1.8, "id_project": 1, "id_character": 3},
}