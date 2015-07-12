package hard;
import java.util.Arrays;


public class Q135_Candy {
	public static int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < dp.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        
        for(int i = dp.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
