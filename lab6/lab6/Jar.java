

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Параметризований клас-контейнер "Банка" для зберігання об'єктів будь-якого типу.
 * Реалізує основні операції з елементами: додавання, вилучення, пошук максимального.
 * 
 * @param <T> тип елементів, які зберігаються в банці (має реалізовувати Comparable)
 * @author Цегинька
 * @version 1.0
 */
public class Jar<T extends Comparable<T>> implements Iterable<T>, Comparable<Jar<T>> {
    /**
     * Внутрішнє сховище для елементів банки
     */
    private ArrayList<T> items;
    
    /**
     * Максимальна ємність банки
     */
    private int capacity;
    
    /**
     * Конструктор з параметром ємності
     * 
     * @param capacity максимальна кількість елементів, які може вмістити банка
     * @throws IllegalArgumentException якщо ємність менша або дорівнює 0
     */
    public Jar(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Ємність банки має бути більше 0");
        }
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }
    
    /**
     * Конструктор за замовчуванням (ємність 10 елементів)
     */
    public Jar() {
        this(10);
    }
    
    /**
     * Додає елемент до банки
     * 
     * @param item елемент для додавання
     * @return true якщо елемент успішно додано, false якщо банка заповнена
     * @throws IllegalArgumentException якщо елемент null
     */
    public boolean add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Не можна додати null елемент");
        }
        if (isFull()) {
            return false;
        }
        return items.add(item);
    }
    
    /**
     * Вилучає елемент за індексом
     * 
     * @param index індекс елемента для вилучення
     * @return вилучений елемент
     * @throws IndexOutOfBoundsException якщо індекс недійсний
     */
    public T remove(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Недійсний індекс: " + index);
        }
        return items.remove(index);
    }
    
    /**
     * Вилучає перший знайдений елемент
     * 
     * @param item елемент для вилучення
     * @return true якщо елемент знайдено та вилучено, false інакше
     */
    public boolean remove(T item) {
        return items.remove(item);
    }
    
    /**
     * Знаходить максимальний елемент у банці (для непарного варіанту 26)
     * 
     * @return максимальний елемент або null якщо банка порожня
     */
    public T findMax() {
        if (isEmpty()) {
            return null;
        }
        
        T max = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            T current = items.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }
    
    /**
     * Отримує елемент за індексом без вилучення
     * 
     * @param index індекс елемента
     * @return елемент за вказаним індексом
     * @throws IndexOutOfBoundsException якщо індекс недійсний
     */
    public T get(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Недійсний індекс: " + index);
        }
        return items.get(index);
    }
    
    /**
     * Перевіряє чи банка порожня
     * 
     * @return true якщо банка порожня, false інакше
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    /**
     * Перевіряє чи банка заповнена
     * 
     * @return true якщо банка заповнена, false інакше
     */
    public boolean isFull() {
        return items.size() >= capacity;
    }
    
    /**
     * Повертає поточну кількість елементів у банці
     * 
     * @return кількість елементів
     */
    public int size() {
        return items.size();
    }
    
    /**
     * Повертає максимальну ємність банки
     * 
     * @return ємність банки
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * Очищує банку, видаляючи всі елементи
     */
    public void clear() {
        items.clear();
    }
    
    /**
     * Повертає ітератор для обходу елементів банки
     * 
     * @return ітератор елементів
     */
    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
    
    /**
     * Повертає рядкове представлення банки
     * 
     * @return рядок з інформацією про вміст банки
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Банка [").append(items.size()).append("/").append(capacity).append("]: ");
        if (isEmpty()) {
            sb.append("порожня");
        } else {
            sb.append(items.toString());
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Jar<T> o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}