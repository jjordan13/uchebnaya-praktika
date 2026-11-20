def search_actors_by_tags(tag_names, tags, actors, actor_tags):
    # Шаг 1: Извлечь ID запрошенных тегов из таблицы ТЕГ
    requested_tag_ids = set()
    for tag_id, tag_data in tags.items():
        if tag_data["tag_name"] in tag_names:
            requested_tag_ids.add(tag_id)
    if not requested_tag_ids:
        return [] # Если теги не найдены, вернуть пустой список

    if len(requested_tag_ids) != len(set(tag_names)):
        return []  # Хотя бы один запрошенный тег не найден

    # Шаг 2: Для каждого актёра проверить, содержит ли он все запрошенные теги
    result_list = []
    for actor_id, actor_data in actors.items():
        # Получить множество тегов актёра
        actor_tag_set = actor_tags.get(actor_id, set())

        # Проверить условие: все запрошенные теги присутствуют у актёра
        if requested_tag_ids.issubset(actor_tag_set):
            # Вычислить рейтинг совпадения (количество дополнительных тегов)
            rating = len(actor_tag_set) - len(requested_tag_ids)
            # Добавить актёра в результирующий список
            result_list.append({
                "actor_id": actor_id,
                "full_name": actor_data["full_name"],
                "demo_reel_url": actor_data["demo_reel_url"],
                "hourly_rate": actor_data["hourly_rate"],
                "rating": rating
            })

    # Шаг 3: Отсортировать результат по убыванию рейтинга
    result_list.sort(key=lambda x: x["rating"], reverse=True)
    return result_list