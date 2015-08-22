package easy;

public class Q66_Plus_One {
	public static int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if(carry == 0) {
            return digits;
        }
        
        int[] result = new int[digits.length + 1];
        for(int i = digits.length; i >= 1; i--) {
            result[i] = digits[i - 1];
        }
        result[0] = carry;
        return result;
    }

	public static void main(String[] args) {
		int[] digits = { 1, 0, 1};
		int[] result = plusOne(digits);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
