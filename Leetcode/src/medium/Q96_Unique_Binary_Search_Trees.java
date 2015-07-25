package medium;

public class Q96_Unique_Binary_Search_Trees {
	public static int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for(int i = 2; i < n + 1; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
}
