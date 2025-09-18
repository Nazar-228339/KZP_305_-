import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Lab1CeginjkaKI305 {
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

            // Створюємо зубчастий масив
            char[][] matrix = new char[n][];

            for (int i = 0; i < n; i++) {
                int count = 0;

                // Рахуємо скільки символів реально буде в цьому рядку
                for (int j = 0; j < n; j++) {
                    if ((j < i && j < n - i - 1) || (j > i && j > n - i - 1)) {
                        count++;
                    }
                }

                // Виділяємо пам'ять тільки під потрібну кількість символів
                matrix[i] = new char[count];

                // Заповнюємо лише необхідні позиції
                int index = 0;
                for (int j = 0; j < n; j++) {
                    if ((j < i && j < n - i - 1) || (j > i && j > n - i - 1)) {
                        matrix[i][index++] = fill;
                    }
                }
            }

            // Вивід у консоль
            System.out.println("\nРезультат:");
            for (int i = 0; i < n; i++) {
                int index = 0;
                for (int j = 0; j < n; j++) {
                    if ((j < i && j < n - i - 1) || (j > i && j > n - i - 1)) {
                        System.out.print(matrix[i][index++] + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }

            // Запис у файл
            try (FileWriter writer = new FileWriter("output.txt")) {
                for (int i = 0; i < n; i++) {
                    int index = 0;
                    for (int j = 0; j < n; j++) {
                        if ((j < i && j < n - i - 1) || (j > i && j > n - i - 1)) {
                            writer.write(matrix[i][index++] + " ");
                        } else {
                            writer.write("  ");
                        }
                    }
                    writer.write(System.lineSeparator());
                }
            }
            System.out.println("✅ Зубчастий масив збережено у output.txt");

        } catch (IOException e) {
            System.out.println("IO помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
