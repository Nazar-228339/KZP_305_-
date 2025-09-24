package KI305.Tsehynka.Lab2;

/**
 * Клас, що описує сидіння в шлюпці.
 */
public class Seat {
    private String capacity; // кількість осіб на сидінні

    public Seat(String capacity) {
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Сидiння для " + capacity + " особи(ей)";
    }
}
