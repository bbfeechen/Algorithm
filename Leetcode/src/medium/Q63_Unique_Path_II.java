package medium;

public class Q63_Unique_Path_II {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] dp = new int[m][n];
		dp[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
		for(int i = 1; i < m; i++) {
			dp[i][0] = (obstacleGrid[i][0] == 0) ? dp[i - 1][0] : 0;
		}
		for(int j = 1; j < n; j++) {
			dp[0][j] = (obstacleGrid[0][j] == 0) ? dp[0][j - 1] : 0;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i][j - 1] + dp[i - 1][j] : 0;
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = {
			{0, 1, 0},
			{0, 0, 0},
			{0, 0, 0}
		};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
}
