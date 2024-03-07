import cgl.Out;

import java.util.Random;

public class main {
    public static boolean[][] tiles;

    public static void main(String[] args) {

        tiles = new boolean[9][9];

        Random random = new Random();

        // Fill the 2D array with random boolean values
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tiles[i][j] = random.nextBoolean();
            }
        }

        Out.displayContent(tiles);

    }

}
