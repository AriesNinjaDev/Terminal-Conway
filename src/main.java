import cgl.Logic;
import cgl.Out;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class main {
    private final static Scanner userInput = new Scanner(System.in, StandardCharsets.UTF_8);

    private static boolean active = true;

    public static void main(String[] args) {

        int boardSize = 25;

        /*
        Important Note:

        The top left position is (0,0), but movement in the vertical direction is considered
        the X-axis. This is the case because when referencing a 2d array, a format exists
        such that (x,y) == myArray[y][x].
         */

        boolean[][] tiles = new boolean[boardSize][boardSize];

        boolean t;

        String lastError = "";

        Random random = new Random();

        while (active) {

            Out.displayContent(tiles);

            //System.out.println(Logic.countNeighbors(tiles, 0, 5));

            System.out.print("\n" + lastError + "\n> ");

            lastError = "";

            String input = userInput.nextLine();

            String[] data = input.split(" ");

            switch (data[0]) {
                case "end":
                    active = false;
                    break;
                case "s":
                    for (int i = 0; i < tiles.length; i++) {
                        for (int j = 0; j < tiles.length; j++) {
                            int n = Logic.countNeighbors(tiles, i, j);
                            if (tiles[i][j] && (n == 1 || n > 3)) {
                                tiles[i][j] = false;
                            } else if ((!tiles[i][j]) && n == 3) {
                                tiles[i][j] = true;
                            }
                        }
                    }
                    break;
                case "reset":
                    for (int i = 0; i < tiles.length; i++) {
                        for (int j = 0; j < tiles.length; j++) {
                            tiles[i][j] = false;
                        }
                    }
                    break;
                case "rand":

                    for (int i = 0; i < boardSize; i++) {
                        for (int j = 0; j < boardSize; j++) {
                            tiles[i][j] = random.nextBoolean();
                        }
                    }
                default:
                    try {
                        int i = Integer.parseInt(data[0]), j = Integer.parseInt(data[1]);
                        tiles[i][j] = !tiles[i][j];
                    } catch (Exception e) {
                        lastError = "Invalid Format.";
                    }
                    break;
            }

        }


    }

}
