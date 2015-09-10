package medium;

public class Q233_Number_of_Digit_One {
	public static int countDigitOne(int n) {
        int res = 0;
        int a = 1;
        int b = 1;
        while(n > 0) {
            res += (n + 8) / 10 * a + (n % 10 == 1 ? 1 : 0) * b;
            b += (n % 10) * a;
            a *= 10;
            n /= 10;
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(countDigitOne(233));
	}
}
