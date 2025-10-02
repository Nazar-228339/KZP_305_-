package KI305.Tsehynka.Lab2;

import java.io.IOException;

/**
 * Клас, що описує шлюпку на веслах.
 */
public class Shlyupka {
    private Hull hull;
    private Oar[] oars;
    private Seat[] seats;

    // Конструктор за замовчуванням (корпус з дерева, 2 весла, 2 сидіння)
    public Shlyupka() {
        this.hull = new Hull("Дерево", 4.5);
        this.oars = new Oar[2];
        this.seats = new Seat[2];
    }

    // Конструктор з параметрами
    public Shlyupka(Hull hull, int oarCount, int seatCount) {
        this.hull = hull;
        this.oars = new Oar[Math.max(0, oarCount)];
        this.seats = new Seat[Math.max(0, seatCount)];
    }

    public Hull getHull() {
        return hull;
    }

    public void setHull(Hull hull) {
        this.hull = hull;
    }

    public void addOar(int index, Oar oar, Logger logger) throws IOException {
        if (index >= 0 && index < oars.length) {
            oars[index] = oar;
            logger.log("Додано весло на позицiю " + index + " (" + oar + ")");
        } else {
            logger.log("Помилка: неправильний iндекс для додавання весла: " + index);
        }
    }

    public void addSeat(int index, Seat seat, Logger logger) throws IOException {
        if (index >= 0 && index < seats.length) {
            seats[index] = seat;
            logger.log("Додано сидiння на позицiю " + index + " (" + seat + ")");
        } else {
            logger.log("Помилка: неправильний iндекс для додавання сидiння: " + index);
        }
    }

    public void removeOar(int index, Logger logger) throws IOException {
        if (index >= 0 && index < oars.length && oars[index] != null) {
            logger.log("Видалено весло з позицiї " + index + " (" + oars[index] + ")");
            oars[index] = null;
        } else {
            logger.log("Помилка при видаленнi весла: позицiя " + index);
        }
    }

    public void removeSeat(int index, Logger logger) throws IOException {
        if (index >= 0 && index < seats.length && seats[index] != null) {
            logger.log("Видалено сидiння з позицiї " + index + " (" + seats[index] + ")");
            seats[index] = null;
        } else {
            logger.log("Помилка при видаленнi сидiння: позицiя " + index);
        }
    }

    public void row(Logger logger) throws IOException {
        logger.log("Веслування розпочато");
    }

    public void stopRowing(Logger logger) throws IOException {
        logger.log("Веслування зупинено");
    }

    public void repairHull(Logger logger) throws IOException {
        logger.log("Виконано ремонт корпусу");
    }

    // Максимальні місця для весел і сидінь
    public int getMaxOars() {
        return oars.length;
    }

    public int getMaxSeats() {
        return seats.length;
    }

    @Override
    public String toString() {
        String hullInfo = (hull != null) ? hull.toString() : "Корпус: вiдсутнiй";
        return "Шлюпка: " + hullInfo +
               ", кiлькiсть мiсць для весел: " + oars.length +
               ", кiлькiсть мiсць для сидiнь: " + seats.length;
    }
}
