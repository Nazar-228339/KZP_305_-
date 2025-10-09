

/**
 * Демонстраційний клас для роботи з {@link MotorBoat}.
 */
public class Main {
    public static void main(String[] args) {
        MotorBoat boat = new MotorBoat("Алюміній", 6.5, 150);
        System.out.println(boat);
        boat.move();
        boat.drive();
    }
}
