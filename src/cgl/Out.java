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
        for (int i = 0; i < tiles.length + 2; i++) System.out.print("   ");
        System.out.print(ANSI_RESET + "\n" + ANSI_BLUE_BACKGROUND + "   " + ANSI_RESET);
        for (boolean[] i : tiles) {
            for (boolean j : i) {
                System.out.print(charMap.get(j));
            }
            System.out.print(ANSI_BLUE_BACKGROUND + "   " + ANSI_RESET + "\n" + ANSI_BLUE_BACKGROUND + "   " + ANSI_RESET);
        }
        System.out.print(ANSI_BLUE_BACKGROUND);
        for (int i = 0; i < tiles.length + 1; i++) System.out.print("   ");
        System.out.print(ANSI_RESET);
    }
}
