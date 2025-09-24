package KI305.Tsehynka.Lab2;

import java.io.IOException;

/**
 * Клас, що описує шлюпку на веслах.
 */
public class Shlyupka {
    private Hull hull;
    private Oar[] oars;
    private Seat[] seats;

    // --- Конструктори ---
    public Shlyupka() {
        this.hull = new Hull("Дерево", 4.5);
        this.oars = new Oar[2];
        this.seats = new Seat[2];
    }

    public Shlyupka(Hull hull, int oarCount, int seatCount) {
        this.hull = hull;
        this.oars = new Oar[oarCount];
        this.seats = new Seat[seatCount];
    }

    // --- Методи ---
    public void addOar(int index, Oar oar, Logger logger) throws IOException {
        if (index >= 0 && index < oars.length) {
            oars[index] = oar;
            logger.log("Додано весло на позицiю " + index);
        } else {
            logger.log("Помилка: неправильний iндекс для додавання весла");
        }
    }

    public void addSeat(int index, Seat seat, Logger logger) throws IOException {
        if (index >= 0 && index < seats.length) {
            seats[index] = seat;
            logger.log("Додано сидiння на позицiю " + index);
        } else {
            logger.log("Помилка: неправильний iндекс для додавання сидiння");
        }
    }

    public int getOarsCount() {
        return oars.length;
    }

    public int getSeatsCount() {
        return seats.length;
    }

    public void row(Logger logger) throws IOException {
        logger.log("Веслування розпочато");
    }

    public void stopRowing(Logger logger) throws IOException {
        logger.log("Веслування зупинено");
    }

    public void repairHull(Logger logger) throws IOException {
        logger.log("Виконано ремонт корпусу шлюпки");
    }

    /**
     * Видаляє весло з вказаної позиції.
     */
    public void removeOar(int index, Logger logger) throws IOException {
        if (index >= 0 && index < oars.length && oars[index] != null) {
            oars[index] = null;
            logger.log("Видалено весло з позицiї " + index);
        } else {
            logger.log("Помилка: неправильний iндекс або весло вiдсутнє на позицiї " + index);
        }
    }

    /**
     * Видаляє сидіння з вказаної позиції.
     */
    public void removeSeat(int index, Logger logger) throws IOException {
        if (index >= 0 && index < seats.length && seats[index] != null) {
            seats[index] = null;
            logger.log("Видалено сидiння з позицiї " + index);
        } else {
            logger.log("Помилка: неправильний iндекс або сидіння вiдсутнє на позицiї " + index);
        }
    }

    @Override
    public String toString() {
        return "Шлюпка: Корпус з матерiалу: " + hull.getMaterial() +
               ", довжина: " + hull.getLength() + " м, кiлькiсть весел: " +
               getOarsCount() + ", кiлькiсть сидiнь: " + getSeatsCount();
    }
}
