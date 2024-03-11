package cgl;

public class Logic {

    private static final int[][] checks = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; // The list of tiles we need to check


    public static int countNeighbors(boolean[][] tiles, int x, int y) {

        int count = 0;
        final int size = tiles.length;

        for (int[] i : checks) { // Iterate through each of the tiles we need to check, relative to the selected tile.
            if (x + i[0] != -1 && x + i[0] != size && // If we aren't touching the left or right wall
                    y + i[1] != -1 && y + i[1] != size && // AND if we aren't touching the top or bottom wall
                    tiles[x + i[0]][y + i[1]]) { // AND if the targeted tile is enabled
                count++; // THEN increment our count of neighbors
            }
        }

        return count; // Return our final amount of neighbors

    }

}
