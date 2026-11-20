from data import tags, actors, actor_tags, audio_assets, casting
from casting import search_actors_by_tags
from sheeting import distribute_assets_to_sessions


if __name__ == "__main__":
    print("=" * 60)
    print("ТЕСТ 1: Алгоритм поиска актёров по тегам")
    print("=" * 60)
    
    search_tags = ["мужской", "низкий тембр"]
    print(f"Запрос: {search_tags}\n")
    
    results = search_actors_by_tags(search_tags, tags, actors, actor_tags)
    
    print("Результаты поиска:")
    for i, actor in enumerate(results, 1):
        print(f"{i}. {actor['full_name']}")
        print(f"   Демо: {actor['demo_reel_url']}")
        print(f"   Ставка: {actor['hourly_rate']} руб./час")
        print(f"   Рейтинг совпадения: {actor['rating']}")
        print()
    
    print("=" * 60)
    print("ТЕСТ 2: Алгоритм распределения реплик по сессиям")
    print("=" * 60)
    
    max_duration = 10.0
    print(f"Максимальная длительность сессии: {max_duration} секунд\n")
    
    sessions = distribute_assets_to_sessions(audio_assets, casting, max_duration)
    
    print("Результаты распределения:")
    for session in sessions:
        print(f"Сессия {session['session_id']}:")
        print(f"  ID актёра: {session['id_actor']}")
        print(f"  Количество реплик: {len(session['asset_ids'])}")
        print(f"  Длительность: {session['duration']:.1f} сек.")
        print(f"  ID реплик: {session['asset_ids']}")
        print()