package easy;

public class Q231_Power_of_Two {
	public static boolean isPowerOfTwo(int n) {
		int count = 0;
		while(n > 0) {
		    if((n & 0x1) == 1) {
		        count++;
		    }
		    n >>= 1;
		}
		return count == 1;
    }

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(8));
		System.out.println(isPowerOfTwo(24));
	}
}
