import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class task4 {
    public static void main(String[] args) {
        String filePath = "randomText.txt";
        writeRandomTextToFile(filePath);
        printTextAndDigits(filePath);
    }

    private static void writeRandomTextToFile(String filePath) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(100);

        for (int i = 0; i < 100; i++) {
            char randomChar = (char) (random.nextInt(96) + 32); // ASCII 32-127: printable characters
            sb.append(randomChar);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void printTextAndDigits(String filePath) {
        try {
            String text = Files.readString(Paths.get(filePath));
            System.out.println(text);

            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }

            System.out.println(sb.toString());

        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
