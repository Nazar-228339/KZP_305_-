package KI305.Tsehynka.Lab2;

public class Main {
    public static void main(String[] args) {
        try (Logger logger = new Logger("log.txt")) {
            Hull hull = new Hull("Алюмiнiй", 5.0);
            Shlyupka boat = new Shlyupka(hull, 2, 2);

            // Додаємо весла
            boat.addOar(0, new Oar("Дерево"), logger);
            boat.addOar(1, new Oar("Дерево"), logger);

            // Додаємо сидіння
            boat.addSeat(0, new Seat("Переднє"), logger);
            boat.addSeat(1, new Seat("Заднє"), logger);

            // Починаємо веслування
            boat.row(logger);

            // Зупиняємо веслування
            boat.stopRowing(logger);

            // Видаляємо елементи
            boat.removeOar(1, logger);
            boat.removeSeat(0, logger);

            // Виводимо оновлений стан
            System.out.println(boat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
