package yelp;

public class yelp_coinchange {
	public static int count(int[] coins, int V) {
		int[][] dp = new int[V + 1][coins.length];
		for(int i = 0; i < coins.length; i++) {
			dp[0][i] = 1;
		}
		for(int i = 1; i < V + 1; i++) {
			for(int j = 0; j < coins.length; j++) {
				int x = (i - coins[j] >= 0) ? dp[i - coins[j]][j] : 0;
				int y = (j >= 1) ? dp[i][j - 1] : 0;
				dp[i][j] = x + y;
			}
		}
		return dp[V][coins.length - 1];
	}

	public static void main(String[] args) {
		int[] coins =  {1, 2, 3};
		System.out.println(count(coins, 4));
	}
}
