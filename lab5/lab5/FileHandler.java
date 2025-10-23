

import java.io.*;

/**
 * Клас {@code FileHandler} реалізує методи запису та читання результатів
 * у текстовому та двійковому форматах.
 *
 * <p>Використовується для збереження та відновлення результатів обчислень,
 * отриманих з класу {@link ExpressionCalculator}.</p>
 *
 * @author Tsehynka
 * @version 1.0
 */
public class FileHandler {

    /**
     * Записує результат у текстовий файл.
     *
     * @param fileName ім’я файлу
     * @param x значення аргументу
     * @param y результат обчислення
     * @throws IOException якщо не вдалося записати у файл
     */
    public void writeText(String fileName, double x, double y) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(String.format("x = %.4f; y = %.4f%n", x, y));
        }
    }

    /**
     * Зчитує дані з текстового файлу та виводить у консоль.
     *
     * @param fileName ім’я файлу
     * @throws IOException якщо не вдалося прочитати файл
     */
    public void readText(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Вміст текстового файлу:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    /**
     * Записує результат у двійковий файл.
     *
     * @param fileName ім’я файлу
     * @param x значення аргументу
     * @param y результат обчислення
     * @throws IOException якщо не вдалося записати у файл
     */
    public void writeBinary(String fileName, double x, double y) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeDouble(x);
            dos.writeDouble(y);
        }
    }

    /**
     * Зчитує дані з двійкового файлу та виводить у консоль.
     *
     * @param fileName ім’я файлу
     * @throws IOException якщо не вдалося прочитати файл
     */
    public void readBinary(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            double x = dis.readDouble();
            double y = dis.readDouble();
            System.out.printf("Зчитано з двійкового файлу: x = %.4f; y = %.4f%n", x, y);
        }
    }
}
