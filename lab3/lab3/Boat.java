

/**
 * Абстрактний клас {@code Boat} описує загальні властивості човнів.
 */
public abstract class Boat {
    protected String material;
    protected double length;

    /**
     * Конструктор човна.
     *
     * @param material матеріал корпусу
     * @param length   довжина човна
     */
    public Boat(String material, double length) {
        this.material = material;
        this.length = length;
    }

    /**
     * Абстрактний метод руху човна.
     */
    public abstract void move();

    @Override
    public String toString() {
        return "Матеріал: " + material + ", довжина: " + length + " м";
    }
}
