# boats/motorboat.py
"""
Модуль, що містить похідний клас Motorboat (Моторний човен).
"""

from .rowboat import Rowboat # Імпорт базового класу з того ж пакета

class Motorboat(Rowboat):
    """
    Похідний клас, що представляє моторний човен.
    Успадковує від Rowboat і додає функціонал двигуна.
    """
    
    def __init__(self, length_m: float, max_passengers: int, engine_power_hp: int):
        """
        Конструктор класу Motorboat.

        :param length_m: Довжина човна в метрах.
        :param max_passengers: Максимальна кількість пасажирів.
        :param engine_power_hp: Потужність двигуна в кінських силах (к.с.).
        """
        # Виклик конструктора базового класу
        super().__init__(length_m, max_passengers)
        
        self._engine_power_hp = engine_power_hp
        self._is_engine_running = False  # Двигун вимкнений за замовчуванням
        
    def start_engine(self):
        """Запустити двигун."""
        if not self._is_engine_running:
            self._is_engine_running = True
            print(f"[{self.__class__.__name__}]: Двигун ({self._engine_power_hp} к.с.) запущено!")
        else:
            print(f"[{self.__class__.__name__}]: Двигун вже працює.")
            
    def stop_engine(self):
        """Зупинити двигун."""
        if self._is_engine_running:
            self._is_engine_running = False
            print(f"[{self.__class__.__name__}]: Двигун зупинено.")
        else:
            print(f"[{self.__class__.__name__}]: Двигун вже вимкнено.")

    def throttle_up(self, speed_kmh: float):
        """Збільшити оберти двигуна/швидкість човна."""
        if not self._is_anchored and self._is_engine_running:
            print(f"[{self.__class__.__name__}]: Рухаємося за допомогою двигуна зі швидкістю {speed_kmh} км/год. Вперед!")
        elif not self._is_engine_running:
            print(f"[{self.__class__.__name__}]: Не можна рухатися, двигун вимкнено!")
        else:
            print(f"[{self.__class__.__name__}]: Не можна рухатися, поки опущено якір!")
            
    # ⭐ ЗМІНА 1: Перевизначення методу row() для логічної коректності
    def row(self):
        """Моторний човен може веслувати лише в аварійній ситуації."""
        print(f"[{self.__class__.__name__}]: Увага: веслування на човні з потужністю {self._engine_power_hp} к.с. є **аварійним режимом**.")
        super().row() # Викликаємо оригінальний метод, але попереджаємо про нелогічність

    # Перевизначення методу базового класу
    def get_info(self) -> str:
        """Повертає повну інформацію про моторний човен."""
        base_info = super().get_info()  # Отримання базової інформації
        engine_status = "Працює" if self._is_engine_running else "Вимкнений"
        
        # Заміна "Шлюпка на веслах" на "Моторний човен"
        motorboat_info = base_info.replace("Шлюпка на веслах", "Моторний човен")
        
        return (f"{motorboat_info.split(' | Статус: ')[0]} | "
                f"Потужність: {self._engine_power_hp} к.с. | "
                f"Двигун: {engine_status} | "
                f"Статус: {'на якорі' if self._is_anchored else 'у русі'}")