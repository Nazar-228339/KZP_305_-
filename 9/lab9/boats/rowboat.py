# boats/rowboat.py
"""
Модуль, що містить базовий клас Rowboat (Шлюпка на веслах).
"""

class Rowboat:
    """
    Базовий клас, що представляє шлюпку на веслах.
    """
    
    def __init__(self, length_m: float, max_passengers: int):
        """
        Конструктор класу Rowboat.

        :param length_m: Довжина шлюпки в метрах.
        :param max_passengers: Максимальна кількість пасажирів.
        """
        self._length_m = length_m
        self._max_passengers = max_passengers
        self._is_anchored = True  # Шлюпка зазвичай стоїть на якорі
        
    def anchor_up(self):
        """Підняти якір, готуючись до руху."""
        if self._is_anchored:
            self._is_anchored = False
            print(f"[{self.__class__.__name__}]: Якір піднято. Готові до відплиття.")
        else:
            print(f"[{self.__class__.__name__}]: Якір вже піднято.")

    def anchor_down(self):
        """Опустити якір, зупиняючи рух."""
        if not self._is_anchored:
            self._is_anchored = True
            print(f"[{self.__class__.__name__}]: Якір опущено. Зупинка.")
        else:
            print(f"[{self.__class__.__name__}]: Якір вже опущено.")

    def row(self):
        """Імітує процес веслування."""
        if not self._is_anchored:
            print(f"[{self.__class__.__name__}]: Веслування розпочато. Човен рухається...")
        else:
            print(f"[{self.__class__.__name__}]: Не можна веслувати, поки опущено якір!")

    def get_info(self) -> str:
        """Повертає загальну інформацію про шлюпку."""
        status = "на якорі" if self._is_anchored else "у русі"
        return (f"Тип: Шлюпка на веслах | Довжина: {self._length_m} м | "
                f"Пасажири: {self._max_passengers} осіб | Статус: {status}")

    def __str__(self):
        """Рядкове представлення об'єкта."""
        return self.get_info()