package easy;

public class Q258_Add_Digits {
	public static int addDigits(int num) {
		String str = String.valueOf(num);
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		if(sum == 0) {
			return 0;
		}
		return (sum % 9 != 0) ? (sum % 9) : 9;
	}

	public static void main(String[] args) {
		System.out.println(addDigits(38));
		System.out.println(addDigits(11));
	}
}
