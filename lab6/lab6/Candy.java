

/**
 * Клас "Цукерка" для демонстрації роботи параметризованого класу Jar.
 * Представляє цукерку з назвою та кількістю калорій.
 * 
 * @author Цегинька
 * @version 1.0
 */
public class Candy implements Comparable<Candy> {
    /**
     * Назва цукерки
     */
    private String name;
    
    /**
     * Кількість калорій
     */
    private int calories;
    
    /**
     * Конструктор класу Candy
     * 
     * @param name назва цукерки
     * @param calories кількість калорій
     * @throws IllegalArgumentException якщо калорії від'ємні
     */
    public Candy(String name, int calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Калорії не можуть бути від'ємними");
        }
        this.name = name;
        this.calories = calories;
    }
    
    /**
     * Отримує назву цукерки
     * 
     * @return назва цукерки
     */
    public String getName() {
        return name;
    }
    
    /**
     * Отримує кількість калорій
     * 
     * @return кількість калорій
     */
    public int getCalories() {
        return calories;
    }
    
    /**
     * Порівнює цукерки за кількістю калорій
     * 
     * @param other інша цукерка для порівняння
     * @return від'ємне число, 0 або додатне число
     */
    @Override
    public int compareTo(Candy other) {
        return Integer.compare(this.calories, other.calories);
    }
    
    /**
     * Повертає рядкове представлення цукерки
     * 
     * @return рядок з інформацією про цукерку
     */
    @Override
    public String toString() {
        return String.format("%s (%d ккал)", name, calories);
    }
    
    /**
     * Перевіряє рівність двох цукерок
     * 
     * @param obj об'єкт для порівняння
     * @return true якщо цукерки рівні, false інакше
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Candy candy = (Candy) obj;
        return calories == candy.calories && name.equals(candy.name);
    }
    
    /**
     * Повертає хеш-код цукерки
     * 
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + calories;
        return result;
    }
}