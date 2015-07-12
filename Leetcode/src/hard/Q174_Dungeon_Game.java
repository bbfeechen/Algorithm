package hard;

public class Q174_Dungeon_Game {
	public static int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) {
            return 0;
        }
        
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        
        for(int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1); 
        }
        
        for(int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1); 
        }
        
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1); 
            }
        }
        return dp[0][0];
    }
	
	public static void main(String[] args) {
		int[][] dungeon = new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
		System.out.println(calculateMinimumHP(dungeon));
	}
}
