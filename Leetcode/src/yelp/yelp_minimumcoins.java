package yelp;

public class yelp_minimumcoins {
	public static int minCoins(int[] coins, int V) {
		int[] dp = new int[V + 1];
		dp[0] = 0;
		for(int i = 1; i <= V; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i = 1; i <= V; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(coins[j] <= i) {
					int sub = dp[i - coins[j]];
					if(sub != Integer.MAX_VALUE && sub + 1 < dp[i]) {
						dp[i] = sub + 1;
					}
				}
			}
		}
		return dp[V];
	}

	public static void main(String[] args) {
		int[] coins =  {9, 6, 5, 1};
		System.out.println(minCoins(coins, 11));
	}
}
