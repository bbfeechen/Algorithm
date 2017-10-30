package easy;

public class Q342_Power_of_Four {
    public static boolean isPowerOfFour(int num) {
        int numOfOne = 0;
        int numOfZero = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                numOfOne++;
            } else {
                numOfZero++;
            }
            num >>= 1;
        }

        return (numOfOne == 1) && (numOfZero % 2 == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(12));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(64));
        System.out.println(isPowerOfFour(-64));
    }
}
