package easy;

public class Q463_Island_Perimeter {
    public static int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        result -= 2;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
