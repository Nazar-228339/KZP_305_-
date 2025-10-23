

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас {@code ExpressionCalculator} реалізує обчислення виразу y = 1 / cos(4x)
 * та запис результату у файл.
 *
 * <p>У випадку виникнення помилок (наприклад, cos(4x) = 0 або проблеми з файлом)
 * генерується виняток, який обробляється у програмі-драйвері.</p>
 *
 * @author Tsehynka
 * @version 1.0
 */
public class ExpressionCalculator {

    /**
     * Обчислює значення виразу y = 1 / cos(4x).
     *
     * @param x значення аргументу
     * @return результат обчислення виразу
     * @throws ArithmeticException якщо cos(4x) = 0
     */
    public double calculate(double x) throws ArithmeticException {
        double denominator = Math.cos(4 * x);
        if (denominator == 0) {
            throw new ArithmeticException("Помилка: cos(4x) = 0, ділення на нуль!");
        }
        return 1 / denominator;
    }

    /**
     * Записує результат обчислення у файл.
     *
     * @param fileName ім’я файлу
     * @param x значення аргументу
     * @param y результат обчислення
     * @throws IOException якщо не вдалося записати у файл
     */
    public void saveToFile(String fileName, double x, double y) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(String.format("x = %.4f; y = %.4f%n", x, y));
        }
    }
}
