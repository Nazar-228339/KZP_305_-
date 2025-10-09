

/**
 * Клас {@code MotorBoat} представляє моторний човен.
 * Наслідує {@link Boat} і реалізує {@link Drivable}.
 */
public class MotorBoat extends Boat implements Drivable {
    private double enginePower;

    /**
     * Конструктор моторного човна.
     *
     * @param material     матеріал корпусу
     * @param length       довжина човна
     * @param enginePower  потужність двигуна (к.с.)
     */
    public MotorBoat(String material, double length, double enginePower) {
        super(material, length);
        this.enginePower = enginePower;
    }

    @Override
    public void move() {
        System.out.println("Моторний човен рухається за допомогою двигуна.");
    }

    @Override
    public void drive() {
        System.out.println("Керування моторним човном здійснюється за допомогою руля.");
    }

    @Override
    public String toString() {
        return "Моторний човен: " + super.toString() +
               ", двигун: " + enginePower + " к.с.";
    }
}
