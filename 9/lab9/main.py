# main.py
"""
Точка входу в програму. Демонструє використання класів Rowboat та Motorboat.
"""

# Імпортуємо класи з пакета boats
from boats import Rowboat, Motorboat

def demonstrate_rowboat():
    """Демонстрація функціоналу класу Rowboat."""
    print("=" * 40)
    print("⭐ Демонстрація Шлюпки на веслах (Rowboat) ⭐")
    print("=" * 40)
    
    # Створення об'єкта
    my_rowboat = Rowboat(length_m=3.5, max_passengers=4)
    print(f"Створено: {my_rowboat}")
    
    # Спроба веслувати, коли якір опущено
    my_rowboat.row()
    
    # Підняття якоря
    my_rowboat.anchor_up()
    
    # Веслування
    my_rowboat.row()
    
    # Опускання якоря
    my_rowboat.anchor_down()
    print(f"Поточний стан: {my_rowboat}")
    print("-" * 40)


def demonstrate_motorboat():
    """Демонстрація функціоналу класу Motorboat."""
    print("=" * 40)
    print("🛥️ Демонстрація Моторного човна (Motorboat) 🛥️")
    print("=" * 40)
    
    # Створення об'єкта
    my_motorboat = Motorboat(length_m=5.0, max_passengers=6, engine_power_hp=150)
    print(f"Створено: {my_motorboat}")
    
    # Сценарій нормального руху
    my_motorboat.anchor_up()
    my_motorboat.start_engine()
    my_motorboat.throttle_up(35.5)
    
    # ⭐ ЗМІНА 2: Виклик row() прибрано з основного сценарію,
    # але ми можемо показати, що він перевизначений:
    print("\n--- Аварійна ситуація ---")
    my_motorboat.row() 
    print("--------------------------\n")
    
    # Зупинка та глушіння двигуна
    my_motorboat.anchor_down()
    my_motorboat.stop_engine()
    
    print(f"Поточний стан: {my_motorboat}")
    print("-" * 40)


if __name__ == "__main__":
    # Виконання демонстраційних функцій
    demonstrate_rowboat()
    print("\n" * 2)
    demonstrate_motorboat()