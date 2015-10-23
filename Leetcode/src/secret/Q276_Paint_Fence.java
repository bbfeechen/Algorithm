package secret;

public class Q276_Paint_Fence {
	public static int numWays(int n, int k) {
		if (n <= 0 || k <= 0) {
            return 0;
        }
         
        if (n == 1) {
            return k;
        }
         
        int preSame = 0;
        int preDiff = k;
         
        for (int i = 1; i < n; i++) {
            int same = preDiff;
            int diff = (k - 1) * (preSame + preDiff);
             
            preSame = same;
            preDiff = diff;
        }
         
        return preSame + preDiff;
    }

	public static void main(String[] args) {
		System.out.println(numWays(3, 2));
		System.out.println(numWays(5, 3));
	}
}
