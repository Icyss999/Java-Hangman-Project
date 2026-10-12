import java.util.Scanner;
// Unfinished 
public class GUI {

    public static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static void drawHangman(int wrong) {
        String head = " ";
        String body = " ";
        String leftArm = " ";
        String rightArm = " ";
        String leftLeg = " ";
        String rightLeg = " ";

        switch (wrong) {
            case 6: rightLeg = ")";
            case 5: leftLeg = "(";
            case 4: rightArm = ">";
            case 3: leftArm = "<";
            case 2: body = "|";
            case 1: head = "O";
        }

        System.out.println("  +----+");
        System.out.println("  |    |");
        System.out.println("  |    " + head);
        System.out.println("  |   " + leftArm + body + rightArm);
        System.out.println("  |   " + leftLeg + " " + rightLeg);
        System.out.println("  |");
        System.out.println("=========");
    }

    public static String formatTime(int seconds) {
        int min = seconds / 60;
        int sec = seconds % 60;

        String minText = (min < 10) ? "0" + min : "" + min;
        String secText = (sec < 10) ? "0" + sec : "" + sec;
        return minText + ":" + secText;
    }

    public static String attemptsBar(int wrong, int maxWrong) {
        String bar = "[";
        for (int i = 1; i <= maxWrong; i++) {
            if (i <= wrong) {
                bar += "X";
            } else {
                bar += "-";
            }
        }
        return bar + "]";
    }

    public static void drawScreen(String category, String maskedWord, String wrongLetters, int wrong, int maxWrong, int seconds, boolean showHint, String hint) {
        clearScreen();
        System.out.println("HANGMAN | Theme:" + category);
        drawHangman(wrong);
        System.out.println();
        System.out.println("Word: " + maskedWord);
        System.out.println("Wrong: " + wrongLetters);
        System.out.println("Attempts: " + attemptsBar(wrong, maxWrong));
        System.out.println("Time: " + formatTime(seconds));
        if (showHint) {
            System.out.println("Hint: " + hint);
        }
    }

    public static void showWinScreen(String word, int seconds) {
        clearScreen();
        System.out.println("You win! The word was " + word);
        System.out.println("Your time: " + formatTime(seconds));
    }

    public static void showLoseScreen(String word) {
        clearScreen();
        drawHangman(6);
        System.out.println();
        System.out.println("Game Over. The word was " + word);
    }
}
