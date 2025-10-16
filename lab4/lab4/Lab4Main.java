

import java.io.IOException;
import java.util.Scanner;

/**
 * Програма-драйвер для демонстрації роботи класу {@link ExpressionCalculator}.
 * Дозволяє користувачу ввести значення x, обчислює y = 1 / cos(4x)
 * і зберігає результат у файл.
 */
public class Lab4Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionCalculator calculator = new ExpressionCalculator();

        try {
            System.out.print("Введiть значення x: ");
            double x = scanner.nextDouble();

            double y = calculator.calculate(x);
            System.out.printf("Результат: y = %.4f%n", y);

            calculator.saveToFile("result.txt", x, y);
            System.out.println("Результат записано у файл result.txt");

        } catch (ArithmeticException e) {
            System.err.println("Помилка при обчисленнi: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка при записi у файл: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Невiдома помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
