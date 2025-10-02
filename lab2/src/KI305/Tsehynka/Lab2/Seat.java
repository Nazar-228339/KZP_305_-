package KI305.Tsehynka.Lab2;

/**
 * Клас, що описує сидіння.
 */
public class Seat {
    private String name;

    public Seat() {
        this.name = "Сидіння";
    }

    public Seat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Сидіння: " + name;
    }
}
