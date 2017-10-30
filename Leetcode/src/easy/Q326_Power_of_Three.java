package easy;

public class Q326_Power_of_Three {

    public static boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(2));
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(-27));
    }
}
