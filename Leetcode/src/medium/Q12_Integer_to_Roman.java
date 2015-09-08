package medium;

public class Q12_Integer_to_Roman {
	public static String intToRoman(int num) {
        int[] nums = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        int digit = 0;
        while(num > 0) {
            int times = num / nums[digit];
            num -= times * nums[digit];
            for(; times > 0; times--) {
                sb.append(symbols[digit]);
            }
            digit++;
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
