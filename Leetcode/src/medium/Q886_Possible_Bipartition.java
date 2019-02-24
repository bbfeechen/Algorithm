package medium;

import java.util.Arrays;

public class Q886_Possible_Bipartition {
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int[N + 1];
        Arrays.fill(colors, -1);
        int[][] grid = new int[N + 1][N + 1];
        for (int[] dislike : dislikes) {
            grid[dislike[0]][dislike[1]] = 1;
            grid[dislike[1]][dislike[0]] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            if (colors[i] == -1 && !isValid(grid, colors, 0, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int[][] grid, int[] colors, int color, int index) {
        if (colors[index] != -1) {
            return colors[index] == color;
        }
        colors[index] = color;
        for (int i = 1; i < grid[index].length; i++) {
            if (grid[index][i] == 1 && !isValid(grid, colors, 1 - color, i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
