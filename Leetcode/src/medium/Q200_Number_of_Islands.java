package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q200_Number_of_Islands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    // dfs(grid, i, j);
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        // UP
        if (j > 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        // DOWN
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
        // LEFT
        if (i > 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        // RIGHT
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
    }

    private static void bfs(char[][] grid, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * grid[0].length + y);

        while (!queue.isEmpty()) {
            int code = queue.poll();
            int i = code / grid[0].length;
            int j = code % grid[0].length;
            grid[i][j] = '0';

            // UP
            if (j > 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                queue.offer(i * grid[0].length + j - 1);
            }
            // DOWN
            if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                queue.offer(i * grid[0].length + j + 1);
            }
            // LEFT
            if (i > 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                queue.offer((i - 1) * grid[0].length + j);
            }
            // RIGHT
            if (i < grid.length - 1 && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                queue.offer((i + 1) * grid[0].length + j);
            }
        }
    }

	public static void main(String[] args) {
		char[][] grid = {{'1', '1', '0', '0', '0'},
				         {'1', '1', '0', '0', '0'},
				         {'0', '0', '1', '0', '0'},
				         {'0', '0', '0', '1', '1'}};
		System.out.println(numIslands(grid));
	}
}
