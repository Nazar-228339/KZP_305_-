import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Лабораторна робота №1
 * Варіант 6
 * Генерація зубчатого масиву (заштриховані лівий та правий трикутники).
 * @author Прізвище Група
 */
public class Lab1ЦегинькаКІ305 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введiть розмiр матрицi n: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введiть символ-заповнювач: ");
            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("❌ Помилка: потрібно ввести рiвно один символ!");
                return;
            }
            char fill = input.charAt(0);

            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((j < i && j < n - i - 1) || (j > i && j > n - i - 1)) {
                        matrix[i][j] = fill;
                    } else {
                        matrix[i][j] = ' ';
                    }
                }
            }

            // Вивід на екран
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            // Запис у файл
            try (FileWriter writer = new FileWriter("output.txt")) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        writer.write(matrix[i][j] + " ");
                    }
                    writer.write(System.lineSeparator());
                }
            }
            System.out.println("✅ Матрицю збережено у output.txt");
        } catch (IOException e) {
            System.out.println("IO помилка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
