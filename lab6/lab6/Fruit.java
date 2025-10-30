

/**
 * Клас "Фрукт" для демонстрації роботи параметризованого класу Jar.
 * Представляє фрукт з назвою та вагою.
 * 
 * @author Цегинька
 * @version 1.0
 */
public class Fruit implements Comparable<Fruit> {
    /**
     * Назва фрукта
     */
    private String name;
    
    /**
     * Вага фрукта в грамах
     */
    private double weight;
    
    /**
     * Конструктор класу Fruit
     * 
     * @param name назва фрукта
     * @param weight вага фрукта в грамах
     * @throws IllegalArgumentException якщо вага від'ємна
     */
    public Fruit(String name, double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Вага не може бути від'ємною");
        }
        this.name = name;
        this.weight = weight;
    }
    
    /**
     * Отримує назву фрукта
     * 
     * @return назва фрукта
     */
    public String getName() {
        return name;
    }
    
    /**
     * Отримує вагу фрукта
     * 
     * @return вага фрукта в грамах
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * Порівнює фрукти за вагою
     * 
     * @param other інший фрукт для порівняння
     * @return від'ємне число, 0 або додатне число
     */
    @Override
    public int compareTo(Fruit other) {
        return Double.compare(this.weight, other.weight);
    }
    
    /**
     * Повертає рядкове представлення фрукта
     * 
     * @return рядок з інформацією про фрукт
     */
    @Override
    public String toString() {
        return String.format("%s (%.1f г)", name, weight);
    }
    
    /**
     * Перевіряє рівність двох фруктів
     * 
     * @param obj об'єкт для порівняння
     * @return true якщо фрукти рівні, false інакше
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fruit fruit = (Fruit) obj;
        return Double.compare(fruit.weight, weight) == 0 && name.equals(fruit.name);
    }
    
    /**
     * Повертає хеш-код фрукта
     * 
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Double.hashCode(weight);
        return result;
    }
}