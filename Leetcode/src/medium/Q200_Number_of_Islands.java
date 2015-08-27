package medium;

public class Q200_Number_of_Islands {
	public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    private static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return;
        }
        if(grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited); 
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }

	public static void main(String[] args) {
		char[][] grid = {{'1', '1', '0', '0', '0'},
				         {'1', '1', '0', '0', '0'},
				         {'0', '0', '1', '0', '0'},
				         {'0', '0', '0', '1', '1'}};
		System.out.println(numIslands(grid));
	}
}
