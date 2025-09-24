package KI305.Tsehynka.Lab2;

/**
 * Клас, що описує корпус шлюпки.
 */
public class Hull {
    private String material;
    private double length;

    public Hull(String material, double length) {
        this.material = material;
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Корпус з матерiалу: " + material + ", довжина: " + length + " м";
    }
}
