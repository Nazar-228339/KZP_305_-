package KI305.Tsehynka.Lab2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Клас для логування дій у файл.
 */
public class Logger implements AutoCloseable {
    private BufferedWriter writer;

    public Logger(String filename) throws IOException {
        writer = new BufferedWriter(new FileWriter(filename, true));
    }

    public void log(String message) throws IOException {
        writer.write(LocalDateTime.now() + " - " + message);
        writer.newLine();
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }
}
