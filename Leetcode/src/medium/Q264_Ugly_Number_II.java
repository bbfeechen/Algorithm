package medium;

public class Q264_Ugly_Number_II {
	public static int nthUglyNumber(int n) {
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;
        int result = 1;
        for(int i = 1; i < n; i++) {
            result = Math.min(next2, Math.min(next3, next5));
            dp[i] = result;
            if(result == next2) {
                i2++;
                next2 = dp[i2] * 2;
            }
            if(result == next3) {
                i3++;
                next3 = dp[i3] * 3;
            }
            if(result == next5) {
                i5++;
                next5 = dp[i5] * 5;
            }
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(10));
	}
}
