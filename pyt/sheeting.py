def distribute_assets_to_sessions(audio_assets, casting, max_session_duration):
    # Шаг 1: персонаж -> утверждённый актёр (один проход по КАСТИНГ)
    char_to_actor = {}
    for (actor_id, char_id), data in casting.items():
        if data["is_approved"]:
            char_to_actor[char_id] = actor_id

    # Шаг 2: группировка ассетов по актёрам в порядке сценария
    actor_assets = {}
    for asset_id in sorted(audio_assets):
        actor_id = char_to_actor.get(audio_assets[asset_id]["id_character"])
        if actor_id is not None:
            actor_assets.setdefault(actor_id, []).append(asset_id)

    # Шаг 3: жадное заполнение сессий внутри каждой группы
    sessions = []
    for actor_id, asset_ids in actor_assets.items():
        current = None
        for asset_id in asset_ids:
            d = audio_assets[asset_id]["duration_target"]
            if d > max_session_duration:
                raise ValueError(f"Ассет {asset_id} длиннее сессии")
            if current is None or current["duration"] + d > max_session_duration:
                current = {"session_id": len(sessions) + 1, "id_actor": actor_id,
                           "asset_ids": [], "duration": 0.0}
                sessions.append(current)
            current["asset_ids"].append(asset_id)
            current["duration"] += d

    for s in sessions:
        s["time_left"] = max_session_duration - s["duration"]
    return sessions