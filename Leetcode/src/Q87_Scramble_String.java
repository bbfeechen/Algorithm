
public class Q87_Scramble_String {
	// isScramble[k][i][j] : s1[i...i + k] can be converted from s2[j...j + k]
    public static boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        if(s1.equals(s2)) {
            return true;
        }
        
        int L = s1.length();
        boolean[][][] isScramble = new boolean[L][L][L];
        for(int i = 0; i < L; i++) {
            for(int j = 0; j < L; j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    isScramble[0][i][j] = true;
                } 
            }
        }
        
        for(int k = 2; k <= L; k++) {
            for(int i = L - k; i >= 0; i--) {
                for(int j = L - k; j >= 0; j--) {
                    boolean canScramble = false;
                    for(int m = 1; m < k; m++) {
                        // front - front / back - back  OR front - back / back - front
                        canScramble = (isScramble[m - 1][i][j] && isScramble[k - m - 1][i + m][j + m]) ||
                            (isScramble[m - 1][i][j + k - m] && isScramble[k - m - 1][i + m][j]);
                        if(canScramble) {
                            break;
                        }
                    }
                    isScramble[k - 1][i][j] = canScramble;
                }
            }
        }
        
        return isScramble[L - 1][0][0];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
