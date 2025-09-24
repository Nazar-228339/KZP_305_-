package KI305.Tsehynka.Lab2;

/**
 * Клас, що описує весло.
 */
public class Oar {
    private String material;

    public Oar(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Весло з матерiалу: " + material;
    }
}
