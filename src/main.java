import cgl.Out;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class main {
    private final static Scanner userInput = new Scanner(System.in, StandardCharsets.UTF_8);

    private static boolean active = true;

    public static void main(String[] args) {

        boolean[][] tiles = new boolean[9][9];

        boolean t;

        while (active) {

            Out.displayContent(tiles);

            System.out.print("\n\n> ");

            String input = userInput.nextLine();

            String[] data = input.split(" ");

            if (data[0].equals("end")) {
                active = false;
            } else if (data[0].equals("set")) {
                try {
                    int i = Integer.parseInt(data[2]), j = Integer.parseInt(data[1]); // Indexes reversed due to 2d Array APoxy
                    tiles[i][j] = !tiles[i][j];
                } catch (Exception e) {
                    System.out.println("Invalid Format.");
                }
            }

        }


    }

}
