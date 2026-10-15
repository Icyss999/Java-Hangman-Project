import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Leaderboard {
    // This class has its main purpose of receive data, save it and display it
    private static final String FILE_NAME = "leaderboard.txt";

    record Entry(String name, int duration) {
    }

    public static void savePlayer(String name, int duration) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("User name is not found");
        if (duration < 0)
            throw new IllegalArgumentException("Duration cannot contain negative value");
        try (FileWriter writer = new FileWriter(FILE_NAME, true);) {
            writer.write("%s,%d%n".formatted(name, duration));
        } catch (IOException e) {
            System.out.println("Data cannot be saved");
        }
    }

    static List<Entry> loadEntries(String pathname) {
        List<Entry> entries = new ArrayList<>();
        try (Scanner readFile = new Scanner(new File(pathname))) {
            while (readFile.hasNextLine()) {
                String[] parts = readFile.nextLine().split(",");
                if (parts.length != 2)
                    continue;
                try {
                    entries.add(new Entry(parts[0].trim(), Integer.parseInt(parts[1].trim())));
                } catch (NumberFormatException e) {
                    System.out.println("The duration format is invalid");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.print("The file does not exist");
        }
        return entries;
    }

    public static void displayPlayer() {
        int index = 1;

        List<Entry> entries = loadEntries(FILE_NAME);
        entries.sort(Comparator.comparingInt(Entry::duration));
        System.out.printf("===== PLAYER LEADERBOARD =====%n");
        for (int i = 0; i < entries.size(); i++) {
            String parseName = entries.get(i).name();
            int parseDuration = entries.get(i).duration();
            System.out.printf("%d, %s with the duraton of %d seconds %n", index,parseName,parseDuration);
            index++;
        }
        System.out.printf("================================%n");

    }
}
