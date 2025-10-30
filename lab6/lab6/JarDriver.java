

/**
 * Програма-драйвер для тестування параметризованого класу Jar.
 * Демонструє роботу з різними типами об'єктів (Fruit та Candy).
 * 
 * @author Цегинька
 * @version 1.0
 */
public class JarDriver {
    
    /**
     * Головний метод програми
     * 
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота 6: Параметризований клас Банка ===\n");
        
        // Тестування банки з фруктами
        testFruitJar();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Тестування банки з цукерками
        testCandyJar();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Тестування банки банок
        testJarOfJars();
    }
    
    /**
     * Тестує роботу з банкою фруктів
     */
    private static void testFruitJar() {
        System.out.println(">>> Тест 1: Банка з фруктами <<<\n");
        
        // Створення банки з ємністю 5
        Jar<Fruit> fruitJar = new Jar<>(5);
        System.out.println("Створено банку для фруктів (ємність: " + fruitJar.getCapacity() + ")");
        System.out.println(fruitJar + "\n");
        
        // Додавання фруктів
        System.out.println("Додаємо фрукти:");
        fruitJar.add(new Fruit("Яблуко", 150.0));
        fruitJar.add(new Fruit("Груша", 180.0));
        fruitJar.add(new Fruit("Апельсин", 200.0));
        fruitJar.add(new Fruit("Банан", 120.0));
        fruitJar.add(new Fruit("Киві", 80.0));
        System.out.println(fruitJar + "\n");
        
        // Спроба додати до заповненої банки
        System.out.println("Спроба додати фрукт до заповненої банки:");
        boolean added = fruitJar.add(new Fruit("Манго", 250.0));
        System.out.println("Результат: " + (added ? "Успішно" : "Неможливо - банка заповнена") + "\n");
        
        // Пошук максимального елемента
        Fruit maxFruit = fruitJar.findMax();
        System.out.println("Найважчий фрукт: " + maxFruit + "\n");
        
        // Обхід елементів за допомогою ітератора
        System.out.println("Вміст банки (через ітератор):");
        for (Fruit fruit : fruitJar) {
            System.out.println("  - " + fruit);
        }
        System.out.println();
        
        // Вилучення елемента
        System.out.println("Вилучаємо елемент за індексом 2:");
        Fruit removed = fruitJar.remove(2);
        System.out.println("Вилучено: " + removed);
        System.out.println(fruitJar + "\n");
        
        // Отримання елемента без вилучення
        System.out.println("Отримання першого елемента:");
        Fruit first = fruitJar.get(0);
        System.out.println("Перший елемент: " + first);
        System.out.println("Кількість елементів: " + fruitJar.size());
    }
    
    /**
     * Тестує роботу з банкою цукерок
     */
    private static void testCandyJar() {
        System.out.println(">>> Тест 2: Банка з цукерками <<<\n");
        
        // Створення банки за замовчуванням
        Jar<Candy> candyJar = new Jar<>();
        System.out.println("Створено банку для цукерок (ємність за замовчуванням: " 
                          + candyJar.getCapacity() + ")");
        System.out.println(candyJar + "\n");
        
        // Додавання цукерок
        System.out.println("Додаємо цукерки:");
        candyJar.add(new Candy("Рошен", 450));
        candyJar.add(new Candy("Конті", 380));
        candyJar.add(new Candy("АВК", 420));
        candyJar.add(new Candy("Корона", 500));
        candyJar.add(new Candy("Світоч", 390));
        System.out.println(candyJar + "\n");
        
        // Пошук максимального елемента
        Candy maxCandy = candyJar.findMax();
        System.out.println("Найкалорійніша цукерка: " + maxCandy + "\n");
        
        // Вилучення конкретного елемента
        Candy toRemove = new Candy("Конті", 380);
        System.out.println("Вилучаємо цукерку: " + toRemove);
        boolean removed = candyJar.remove(toRemove);
        System.out.println("Результат: " + (removed ? "Успішно" : "Не знайдено"));
        System.out.println(candyJar + "\n");
        
        // Очищення банки
        System.out.println("Очищаємо банку...");
        candyJar.clear();
        System.out.println(candyJar);
        System.out.println("Банка порожня? " + candyJar.isEmpty());
    }
    
    /**
     * Тестує роботу з банкою банок (вкладені параметризовані типи)
     */
    private static void testJarOfJars() {
        System.out.println(">>> Тест 3: Банка банок (складні параметризовані типи) <<<\n");
        
        // Створення банки банок
        Jar<Jar<Fruit>> jarOfJars = new Jar<>(3);
        System.out.println("Створено банку для зберігання банок з фруктами\n");
        
        // Створення та заповнення першої банки
        Jar<Fruit> jar1 = new Jar<>(3);
        jar1.add(new Fruit("Червоне яблуко", 160.0));
        jar1.add(new Fruit("Зелене яблуко", 155.0));
        
        // Створення та заповнення другої банки
        Jar<Fruit> jar2 = new Jar<>(3);
        jar2.add(new Fruit("Лимон", 85.0));
        jar2.add(new Fruit("Лайм", 75.0));
        jar2.add(new Fruit("Мандарин", 90.0));
        
        // Створення третьої банки
        Jar<Fruit> jar3 = new Jar<>(2);
        jar3.add(new Fruit("Ананас", 300.0));
        
        // Додавання банок до головної банки
        jarOfJars.add(jar1);
        jarOfJars.add(jar2);
        jarOfJars.add(jar3);
        
        System.out.println("Додано 3 банки:");
        System.out.println("Кількість банок у головній банці: " + jarOfJars.size() + "\n");
        
        // Перегляд вмісту
        System.out.println("Вміст кожної банки:");
        for (int i = 0; i < jarOfJars.size(); i++) {
            Jar<Fruit> currentJar = jarOfJars.get(i);
            System.out.println("  Банка " + (i + 1) + ": " + currentJar);
            
            // Знаходження максимального фрукта в поточній банці
            Fruit maxInJar = currentJar.findMax();
            System.out.println("    Найважчий фрукт: " + maxInJar);
        }
        
        // Пошук найбільшої банки (за кількістю елементів)
        System.out.println("\nПошук найповнішої банки:");
        Jar<Fruit> maxJar = jarOfJars.findMax();
        System.out.println("Найповніша банка: " + maxJar);
    }
}