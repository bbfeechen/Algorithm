package hard;

public class Q730_Count_Different_Palindromic_Subsequences {
    private static final int MOD = (int) Math.pow(10, 9) + 7;

    public static int countPalindromicSubsequences(String S) {
        if (S == null || S.isEmpty()) {
            return 0;
        }
        int len = S.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int distance = 1; distance < len; distance++) {
            for (int i = 0; i < len - distance; i++) {
                int j = i + distance;
                if (S.charAt(i) == S.charAt(j)) {
                    int low = i + 1;
                    int high = j - 1;
                    while (low <= high && S.charAt(low) != S.charAt(j)) {
                        low++;
                    }
                    while (high >= low && S.charAt(high) != S.charAt(j)) {
                        high--;
                    }
                    if (low > high) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else if (low == high) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[low + 1][high - 1];
                    }
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + MOD : dp[i][j] % MOD;
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        String S = "bccb";
        System.out.println(countPalindromicSubsequences(S));
        S = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
        System.out.println(countPalindromicSubsequences(S));
    }
}
