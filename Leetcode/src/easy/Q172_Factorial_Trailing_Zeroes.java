package easy;

public class Q172_Factorial_Trailing_Zeroes {
	public static int trailingZeroes(int n) {
        // Trailing 0s in n! = Count of 5s in prime factors of n!
        //          = floor(n/5) + floor(n/25) + floor(n/125) + ....
        int count = 0;
        while(n != 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

	public static void main(String[] args) {
		System.out.println(trailingZeroes(28));
	}
}
