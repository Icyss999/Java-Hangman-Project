import java.util.Scanner;
/* Unfinished */
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
}
