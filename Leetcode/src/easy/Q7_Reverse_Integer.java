package easy;

public class Q7_Reverse_Integer {
	public static int reverse(int x) {
        int sign = 1;
        if(x < 0) {
            sign = -1;
        }
        int num = Math.abs(x);
        long result = 0;
        while(num > 0) {
            result = result * 10 + num % 10;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            num = num / 10;
        }
        return sign * (int)result;
    }

	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}
}
