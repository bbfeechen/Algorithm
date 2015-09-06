package medium;

public class Q29_Divide_Two_Integers {
	public static int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int ans = 0;
        while(a >= b) {
            int shift = 0;
            while(a >= (b << shift)) {
                shift++;
            }
            ans += (1 << (shift - 1));
            a -= (b << (shift - 1));
        }
        if(ans < 0 && sign > 0) {
            return Integer.MAX_VALUE;
        }
        return (int)(ans * sign);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
