package medium;

public class Q221_Maximal_Square {
	public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            dp[i][0] = Integer.valueOf(matrix[i][0] + "");
        }
        for(int j = 0; j < n; j++) {
            dp[0][j] = Integer.valueOf(matrix[0][j] + "");
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

	public static void main(String[] args) {
		char[][] matrix = {{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}};
		System.out.println(maximalSquare(matrix));
	}
}
