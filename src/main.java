import cgl.Logic;
import cgl.Out;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class main {
    private final static Scanner userInput = new Scanner(System.in, StandardCharsets.UTF_8);

    private static boolean active = true;

    public static void main(String[] args) {

        /*
        Important Note:

        The top left position is (0,0), but movement in the vertical direction is considered
        the X-axis. This is the case because when referencing a 2d array, a format exists
        such that (x,y) == myArray[y][x].
         */

        boolean[][] tiles = new boolean[9][9];

        boolean t;

        String lastError = "";

        while (active) {

            Out.displayContent(tiles);

            System.out.println(Logic.countNeighbors(tiles, 0, 5));

            System.out.print("\n" + lastError + "\n> ");

            lastError = "";

            String input = userInput.nextLine();

            String[] data = input.split(" ");

            if (data[0].equals("end")) {
                active = false;
            } else if (data[0].equals("step")) {

            } else {
                try {
                    int i = Integer.parseInt(data[0]), j = Integer.parseInt(data[1]);
                    tiles[i][j] = !tiles[i][j];
                } catch (Exception e) {
                    lastError = "Invalid Format.";
                }
            }

        }


    }

}
