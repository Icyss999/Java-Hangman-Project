
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static final int MAX_WRONG = 6;
    static final int HINT_EVERY = 2;

    public static String lettersOnly(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                result += text.charAt(i);
            }
        }
        return result;
    }

    public static String buildMasked(String word, String guessed) {
        String masked = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isLetter(c) || guessed.indexOf(c) != -1) {
                masked += c + " ";
            } else {
                masked += "_ ";
            }
        }
        return masked;
    }

    public static boolean isWordFound(String word, String guessed) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c) && guessed.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static String buildHintText(int category, int wordIndex, int wrong) {
        int hintsEarned = wrong / HINT_EVERY;
        String text = "";
        String last = "";
        for (int i = 0; i < hintsEarned; i++) {
            String hint = WordBank.getHint(category, wordIndex, i).trim();
            if (!hint.equals(last)) {
                if (!text.isEmpty()) {
                    text += " | ";
                }
                text += hint;
                last = hint;
            }
        }
        return text;
    }

    public static boolean askYesNo(Scanner scanner, String question) {
        while (true) {
            System.out.print(question);
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y") || answer.equals("yes")) {
                return true;
            }
            if (answer.equals("n") || answer.equals("no")) {
                return false;
            }
            System.out.println("Please type y or n.");
        }
    }

    public static String askPlayerName(Scanner scanner) {
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter your name for the leaderboard: ");
            name = scanner.nextLine().replace(",", " ").trim();
        }
        return name;
    }

    public static int askMenuChoice(Scanner scanner) {
        while (true) {
            System.out.println("===== HANGMAN =====");
            System.out.println("1. Play");
            System.out.println("2. Leaderboard");
            System.out.println("3. Quit");
            System.out.print("Your choice (number or name): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("1") || input.equals("play")) {
                return 1;
            }
            if (input.equals("2") || input.equals("leaderboard")) {
                return 2;
            }
            if (input.equals("3") || input.equals("quit") || input.equals("exit")) {
                return 3;
            }
            System.out.println("Invalid choice, please try again.");
        }
    }

    public static boolean playRound(Scanner scanner) {

        // 1. Category and word
        int category = WordBank.askUserForCategory(scanner);
        int wordIndex = WordBank.pickRandomWordIndex();
        String word = WordBank.getWord(category, wordIndex);
        String categoryName = WordBank.getCategoryName(category);

        String guessed = "";
        String wrongLetters = "";
        int wrong = 0;
        String message = "";
        boolean won = false;

        TimeTracker timer = new TimeTracker();
        timer.start();

        while (wrong < MAX_WRONG && !won) {

            GUI.drawScreen(categoryName,
                    buildMasked(word, guessed),
                    wrongLetters,
                    wrong,
                    MAX_WRONG,
                    timer.getElapsedSeconds(),
                    wrong >= HINT_EVERY,
                    buildHintText(category, wordIndex, wrong));

            if (!message.isEmpty()) {
                System.out.println(message);
            }
            System.out.print("Guess a letter or the whole word: ");
            String input = scanner.nextLine().trim().toLowerCase();
            message = "";

            if (input.length() > 1) {
                if (lettersOnly(input).equals(lettersOnly(word))) {
                    guessed = word;
                } else {
                    wrong++;
                    message = "\"" + input + "\" is not the word.";
                }

            } else if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                char guess = input.charAt(0);

                if (guessed.indexOf(guess) != -1) {
                    message = "You already tried '" + guess + "'.";
                } else {
                    guessed += guess;
                    if (word.indexOf(guess) == -1) {
                        wrong++;
                        wrongLetters += guess + " ";
                        message = "No '" + guess + "' in the word.";
                    } else {
                        message = "Good guess!";
                    }
                }

            } else {
                message = "Please type one letter or a word.";
            }

            won = isWordFound(word, guessed);
        }

        int seconds = timer.stop();

        if (won) {
            GUI.showWinScreen(word, seconds);
            String name = askPlayerName(scanner);
            Leaderboard.savePlayer(name, seconds);
            System.out.println();
            Leaderboard.displayPlayer();
        } else {
            GUI.showLoseScreen(word);
        }
        return won;
    }

    public static boolean isDisplayLeaderboard(Scanner scanner, boolean displaying) {
        System.out.print("Enter 0 to exit the leaderboard: ");
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice == 0) return !displaying;
                else {
                System.out.print("Nah this ain't number 0, please try again: ");
             }
            } catch (InputMismatchException e) {
                System.out.print("Hmm this doesn't like a number to me, try again: ");
                scanner.nextLine();
            }
           
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            int choice = askMenuChoice(scanner);

            if (choice == 1) {
                boolean playing = true;
                while (playing) {
                    boolean won = playRound(scanner);

                    if (won) {
                        playing = false; // back to the main menu
                    } else {
                        System.out.println();
                        playing = askYesNo(scanner, "Retry? (y = retry, n = exit): ");
                        if (!playing) {
                            running = false; // exit the program
                        }
                    }
                }
            } else if (choice == 2) {
                boolean displaying = true;
                while(displaying){
                    System.out.println();
                    Leaderboard.displayPlayer();
                    displaying = isDisplayLeaderboard(scanner, displaying);
                }   
            } else {
                running = false;
            }
        }

        System.out.println("\nThanks for playing!");
    }
}
