package cgl;

import java.util.HashMap;
import java.util.Map;

public class Out {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final Map<Boolean, String> charMap = new HashMap<>();

    static {
        charMap.put(true, ANSI_RED_BACKGROUND + "   " + ANSI_RESET);
        charMap.put(false, "   ");
    }

    public static void displayContent(boolean[][] tiles) {
        System.out.print(ANSI_RESET + "\n\n\n\n\n\n\n\n\n\n\n" + ANSI_BLUE_BACKGROUND);
        System.out.print("   ");

        // Print column numbers
        for (int i = 0; i < tiles.length; i++)
            System.out.print(" " + i + " ");

        System.out.println("   " + ANSI_RESET);

        // Print tile content
        for (int i = 0; i < tiles.length; i++) {
            System.out.print(ANSI_BLUE_BACKGROUND + " " + i + " " + ANSI_RESET);

            // Print row content
            for (boolean j : tiles[i]) {
                System.out.print(charMap.get(j));
            }

            System.out.print(ANSI_BLUE_BACKGROUND + "   " + ANSI_RESET + "\n");
        }

        // Print bottom border
        System.out.print(ANSI_BLUE_BACKGROUND);
        for (int i = 0; i < tiles.length + 2; i++)
            System.out.print("   ");

        System.out.print(ANSI_RESET);
    }

}
