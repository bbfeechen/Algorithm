package hard;

public class Q132_Palindrome_Partitioning_II {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                boolean isPalindrome = ((s.charAt(i) == s.charAt(j) 
                    && ((j - i < 2) || isPalin[i + 1][j - 1])));
                isPalin[i][j] = isPalindrome; 
            }
        }
        
        int[] d = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = n - 1 - i;
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(isPalin[i][j]) {
                   if(j == n - 1) { 
                       d[i] = 0;        
                   } else {
                       d[i] = Math.min(d[i], d[j + 1] + 1);
                   }
                }
            }
        }
        return d[0];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
