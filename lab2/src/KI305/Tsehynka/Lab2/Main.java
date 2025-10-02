package KI305.Tsehynka.Lab2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Клас-драйвер для створення шлюпки з підтримкою українських символів (UTF-8).
 */
public class Main {
    public static void main(String[] args) {
        try (
            Logger logger = new Logger("log.txt");
            Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8))
        ) {
            System.out.println("=== Створення шлюпки ===");

            // --- Значення за замовчуванням ---
            String defaultMaterial = "Алюмiнiй";
            double defaultLength = 5.0;
            int defaultOarCount = 2;
            int defaultSeatCount = 2;

            // --- Зчитування параметрів ---
            String material = askString(scanner, "Матерiал корпусу", defaultMaterial);
            double length = askDouble(scanner, "Довжина корпусу (м)", defaultLength);
            int oarCount = askInt(scanner, "Кiлькiсть мiсць для весел", defaultOarCount);
            int seatCount = askInt(scanner, "Кiлькiсть мiсць для сидiнь", defaultSeatCount);

            // --- Створення об'єкта ---
            Shlyupka boat = new Shlyupka(new Hull(material, length), oarCount, seatCount);
            System.out.println("\nСтворено шлюпку:\n" + boat);

// --- Додавання весел ---
System.out.print("\nВведiть матерiал для всiх весел (Enter = пропустити): ");
String commonOarMaterial = scanner.nextLine().trim();
if (!commonOarMaterial.isEmpty()) {
    for (int i = 0; i < boat.getMaxOars(); i++) {
        boat.addOar(i, new Oar(commonOarMaterial), logger);
    }
}

// --- Додавання сидінь ---
System.out.print("\nВведiть назву для всiх сидiнь (Enter = пропустити): ");
String commonSeatName = scanner.nextLine().trim();
if (!commonSeatName.isEmpty()) {
    for (int i = 0; i < boat.getMaxSeats(); i++) {
        boat.addSeat(i, new Seat(commonSeatName), logger);
    }
}


            System.out.println("\nПоточний стан:\n" + boat);

            // --- Веслування ---
            boat.row(logger);
            System.out.println("\nВеслування розпочато! (Enter = зупинити)");
            scanner.nextLine();
            boat.stopRowing(logger);

            // --- Видалення елементів ---
            int idx = askInt(scanner, "\nВведiть iндекс весла для видалення (-1 = пропустити)", -1);
            if (idx >= 0) boat.removeOar(idx, logger);

            idx = askInt(scanner, "Введiть iндекс сидiння для видалення (-1 = пропустити)", -1);
            if (idx >= 0) boat.removeSeat(idx, logger);

            System.out.println("\nФiнальний стан:\n" + boat);

        } catch (IOException ex) {
            System.err.println("Помилка вводу/виводу: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Помилка виконання: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // --- Допоміжні методи ---
    private static String askString(Scanner sc, String msg, String def) {
        System.out.print(msg + (def.isEmpty() ? "" : " [" + def + "]") + ": ");
        String input = sc.nextLine().trim();
        return input.isEmpty() ? def : input;
    }

    private static int askInt(Scanner sc, String msg, int def) {
        try {
            return Integer.parseInt(askString(sc, msg, String.valueOf(def)));
        } catch (Exception e) {
            return def;
        }
    }

    private static double askDouble(Scanner sc, String msg, double def) {
        try {
            return Double.parseDouble(askString(sc, msg, String.valueOf(def)).replace(',', '.'));
        } catch (Exception e) {
            return def;
        }
    }
}
