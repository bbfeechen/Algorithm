
public class Q115_Distinct_Subsequences {
	public static int numDistinct(String S, String T) {
        if(S == null || S.length() == 0) {
            return 0;
        }
        int m = S.length();
        int n = T.length();
        
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++) {
            dp[i][0] = 1; 
        }
        
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if(S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

	public static void main(String[] args) {
		String S = "rabbbit", T = "rabbit";
		System.out.println(numDistinct(S, T));
	}
}
