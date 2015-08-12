package easy;

public class Q9_Palindrome_Number {
	public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        return reverse(x) == x;
    }
    
    private static int reverse(int x) {
        int result = 0;
        while(x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(isPalindrome(12321));
		System.out.println(isPalindrome(45321));
	}
}
