import sys

def generate_jagged_list_variant_6():
    """
    Генерує зубчастий список для варіанту №6 ("пісочний годинник").
    Заштриховані області — ЗОВНІШНІ частини матриці (по краях).
    В середині (форма пісочного годинника) — порожньо.
    """
    # 1. Введення розміру
    try:
        N = int(input("Введіть розмір квадратної матриці (N): "))
        if N <= 0:
            print("Помилка: Розмір має бути > 0.")
            sys.exit(1)
    except ValueError:
        print("Помилка: потрібно ввести ціле число.")
        sys.exit(1)

    # 2. Введення символу
    filler = input("Введіть символ-заповнювач: ")
    if len(filler) != 1:
        print("Помилка: введіть рівно один символ.")
        sys.exit(1)

    # 3. Ініціалізація матриці
    visual = [[' ' for _ in range(N)] for _ in range(N)]
    jagged_list = []
    
    # 4. Генерація зубчастого списку
    # Пісочний годинник: порожньо всередині, заштриховано зовні
    mid = N // 2
    
    for i in range(N):
        row = []
        for j in range(N):
            # Визначаємо, чи клітинка всередині пісочного годинника (порожня)
            if i < mid:
                # Верхня половина: порожньо між діагоналями
                inside = (j > i and j < N - 1 - i)
            elif i > mid:
                # Нижня половина: порожньо між діагоналями
                inside = (j >= N - 1 - i and j <= i)
            else:
                # Середній рядок (для непарних N)
                inside = (j >= N - 1 - i and j <= i)
            
            # Заштриховані області — це все, що НЕ всередині
            if not inside:
                row.append(filler)
                visual[i][j] = '#'
        
        jagged_list.append(row)

    # 5. Виведення результату
    print("\n" + "="*40)
    print("Квадратна матриця з позначеними заштрихованими (заповненими) областями:")
    print("="*40)
    for row in visual:
        print(" ".join(row))
    print("\n" + "-"*40)
    print("Зубчастий масив (по рядках):")
    print("-"*40)
    for i, row in enumerate(jagged_list):
        print(f"Рядок {i}: {row}")
    print("="*40)
    print(f"Загальна кількість рядків: {len(jagged_list)}")

    return jagged_list, visual


if __name__ == "__main__":
    generate_jagged_list_variant_6()