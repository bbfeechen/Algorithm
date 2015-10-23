package linkedin;

public class LongestPalindromeSubsequence {
	public static int lps(String str) {
		int N = str.length();
		int[][] dp = new int[N][N];  
		 
		// Strings of length 1 are palindrome of lentgh 1
		for(int i = 0; i < N; i++) {
			dp[i][i] = 1;
		}
		 
		for(int k = 2; k <= N; k++) {
			for(int i = 0; i < N - k + 1; i++) {
				int j = i + k - 1;
		        if(str.charAt(i) == str.charAt(j) && k == 2) {
		        	dp[i][j] = 2;
		        } else if(str.charAt(i) == str.charAt(j)) {
		            dp[i][j] = dp[i + 1][j - 1] + 2;
		        } else {
		            dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
		        }
		    }
		}
		return dp[0][N-1];
	}

	public static void main(String[] args) {
		String s = "GEEKS FOR GEEKS";
		System.out.println(lps(s));
	}
}
