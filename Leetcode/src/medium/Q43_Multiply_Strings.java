package medium;

public class Q43_Multiply_Strings {
	public static String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] num3 = new int[length1 + length2];
        
        for(int i = length1 - 1; i >= 0; i--) {
            int carry = 0;
            int j = length2 - 1;
            for(; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + num3[i + j + 1] + carry;
                carry = product / 10;
                num3[i + j + 1] = product % 10;
            }
            num3[i + j + 1] = carry;
        }
        
        int index = 0;
        while(index < num3.length - 1 && num3[index] == 0) {
            index++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = index; i < num3.length; i++) {
            sb.append(num3[i]);
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		String num1 = "12";
		String num2 = "11";
		System.out.println(multiply(num1, num2));
	}
}
