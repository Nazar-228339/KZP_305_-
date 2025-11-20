"""
Модуль для обчислення функції y = 1/cos(4x) = sec(4x)

Варіант: 26
Функція: y = 1/cos(4x)

Модуль реалізує:
- Обчислення значень функції для заданого діапазону x
- Збереження результатів у текстовий файл
- Збереження результатів у двійковий файл (pickle)
- Читання даних з текстового файлу
- Читання даних з двійкового файлу
"""

import math
import pickle
import os


def calculate_function(x):
    """
    Обчислює значення функції y = 1/cos(4x)
    
    Параметри:
        x (float): Значення аргументу x
    
    Повертає:
        float: Значення функції y
        None: Якщо cos(4x) = 0 (функція не визначена)
    
    Виключення:
        ValueError: Якщо функція не визначена в точці x
    """
    try:
        cos_value = math.cos(4 * x)
        
        # Перевірка на ділення на нуль (cos(4x) = 0)
        if abs(cos_value) < 1e-10:
            raise ValueError(f"Функція не визначена в точці x = {x}, оскільки cos(4x) = 0")
        
        y = 1 / cos_value
        return y
    
    except ValueError as e:
        print(f"Помилка: {e}")
        return None


def generate_data(x_start, x_end, step):
    """
    Генерує дані для функції y = 1/cos(4x) в заданому діапазоні
    
    Параметри:
        x_start (float): Початкове значення x
        x_end (float): Кінцеве значення x
        step (float): Крок зміни x
    
    Повертає:
        list: Список кортежів (x, y), де y - значення функції
    """
    data = []
    x = x_start
    
    while x <= x_end:
        y = calculate_function(x)
        if y is not None:
            data.append((x, y))
        x += step
    
    return data


def save_to_text_file(data, filename="results.txt"):
    """
    Зберігає дані у текстовий файл
    
    Параметри:
        data (list): Список кортежів (x, y)
        filename (str): Ім'я файлу для збереження
    """
    try:
        with open(filename, 'w', encoding='utf-8') as file:
            file.write("=" * 50 + "\n")
            file.write("Результати обчислення функції y = 1/cos(4x)\n")
            file.write("=" * 50 + "\n\n")
            file.write(f"{'x':^15} | {'y':^25}\n")
            file.write("-" * 50 + "\n")
            
            for x, y in data:
                file.write(f"{x:^15.6f} | {y:^25.10f}\n")
            
            file.write("=" * 50 + "\n")
        
        print(f"✓ Дані успішно збережено у текстовий файл '{filename}'")
    
    except IOError as e:
        print(f"✗ Помилка при збереженні у текстовий файл: {e}")


def read_from_text_file(filename="results.txt"):
    """
    Читає дані з текстового файлу
    
    Параметри:
        filename (str): Ім'я файлу для читання
    
    Повертає:
        list: Список кортежів (x, y) або None при помилці
    """
    try:
        data = []
        with open(filename, 'r', encoding='utf-8') as file:
            lines = file.readlines()
            
            # Пропускаємо заголовки (перші 5 рядків)
            for line in lines[5:]:
                line = line.strip()
                if line and line[0] != '=' and line[0] != '-':
                    parts = line.split('|')
                    if len(parts) == 2:
                        x = float(parts[0].strip())
                        y = float(parts[1].strip())
                        data.append((x, y))
        
        print(f"✓ Дані успішно прочитано з текстового файлу '{filename}'")
        return data
    
    except FileNotFoundError:
        print(f"✗ Файл '{filename}' не знайдено")
        return None
    except Exception as e:
        print(f"✗ Помилка при читанні текстового файлу: {e}")
        return None


def save_to_binary_file(data, filename="results.pkl"):
    """
    Зберігає дані у двійковий файл (pickle)
    
    Параметри:
        data (list): Список кортежів (x, y)
        filename (str): Ім'я файлу для збереження
    """
    try:
        with open(filename, 'wb') as file:
            pickle.dump(data, file)
        
        print(f"✓ Дані успішно збережено у двійковий файл '{filename}'")
    
    except IOError as e:
        print(f"✗ Помилка при збереженні у двійковий файл: {e}")


def read_from_binary_file(filename="results.pkl"):
    """
    Читає дані з двійкового файлу (pickle)
    
    Параметри:
        filename (str): Ім'я файлу для читання
    
    Повертає:
        list: Список кортежів (x, y) або None при помилці
    """
    try:
        with open(filename, 'rb') as file:
            data = pickle.load(file)
        
        print(f"✓ Дані успішно прочитано з двійкового файлу '{filename}'")
        return data
    
    except FileNotFoundError:
        print(f"✗ Файл '{filename}' не знайдено")
        return None
    except Exception as e:
        print(f"✗ Помилка при читанні двійкового файлу: {e}")
        return None


def display_data(data, title="Результати"):
    """
    Виводить дані на екран у форматованому вигляді
    
    Параметри:
        data (list): Список кортежів (x, y)
        title (str): Заголовок для виводу
    """
    if data is None or len(data) == 0:
        print("Немає даних для виводу")
        return
    
    print("\n" + "=" * 50)
    print(f"{title}")
    print("=" * 50)
    print(f"{'x':^15} | {'y':^25}")
    print("-" * 50)
    
    for x, y in data:
        print(f"{x:^15.6f} | {y:^25.10f}")
    
    print("=" * 50 + "\n")


def main():
    """
    Головна функція програми
    Демонструє роботу всіх функцій модуля
    """
    print("\n" + "=" * 60)
    print("Програма обчислення функції y = 1/cos(4x)")
    print("Варіант 26")
    print("=" * 60 + "\n")
    
    # Параметри для генерації даних
    x_start = 0.0
    x_end = 0.7
    step = 0.1
    
    print(f"Діапазон: x ∈ [{x_start}, {x_end}]")
    print(f"Крок: {step}\n")
    
    # 1. Генерація даних
    print("1. Генерація даних...")
    data = generate_data(x_start, x_end, step)
    display_data(data, "Обчислені значення функції")
    
    # 2. Збереження у текстовий файл
    print("2. Збереження у текстовий файл...")
    save_to_text_file(data, "results.txt")
    print()
    
    # 3. Збереження у двійковий файл
    print("3. Збереження у двійковий файл...")
    save_to_binary_file(data, "results.pkl")
    print()
    
    # 4. Читання з текстового файлу
    print("4. Читання з текстового файлу...")
    data_from_text = read_from_text_file("results.txt")
    if data_from_text:
        display_data(data_from_text[:5], "Перші 5 записів з текстового файлу")
    
    # 5. Читання з двійкового файлу
    print("5. Читання з двійкового файлу...")
    data_from_binary = read_from_binary_file("results.pkl")
    if data_from_binary:
        display_data(data_from_binary[:5], "Перші 5 записів з двійкового файлу")
    
    # 6. Демонстрація обробки помилок
    print("6. Демонстрація обробки точок розриву...")
    print("Спроба обчислити функцію в точці x = π/8 ≈ 0.3927")
    print("(В цій точці cos(4x) = cos(π/2) = 0, функція не визначена)")
    test_x = math.pi / 8
    result = calculate_function(test_x)
    print()
    
    print("=" * 60)
    print("Програма завершила роботу успішно!")
    print("=" * 60 + "\n")


if __name__ == "__main__":
    main()