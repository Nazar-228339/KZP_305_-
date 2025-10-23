

import java.io.IOException;
import java.util.Scanner;

/**
 * Програма-драйвер для перевірки роботи класів {@link ExpressionCalculator}
 * та {@link FileHandler}.
 *
 * <p>Виконує обчислення виразу y = 1 / cos(4x) та демонструє запис/читання
 * у текстовому і двійковому форматах.</p>
 */
public class Lab5Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionCalculator calculator = new ExpressionCalculator();
        FileHandler handler = new FileHandler();

        try {
            System.out.print("Введіть значення x: ");
            double x = scanner.nextDouble();

            double y = calculator.calculate(x);
            System.out.printf("Результат обчислення: y = %.4f%n", y);

            // Запис у текстовий і двійковий формат
            handler.writeText("result_text.txt", x, y);
            handler.writeBinary("result_bin.bin", x, y);

            System.out.println("Дані записано у файли result_text.txt та result_bin.bin");

            // Зчитування з файлів
            handler.readText("result_text.txt");
            handler.readBinary("result_bin.bin");

        } catch (ArithmeticException e) {
            System.err.println("Помилка при обчисленні: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлом: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
