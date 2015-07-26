package easy;

public class Q67_Add_Binary {
	public static String addBinary(String a, String b) {
		if(a.length() < b.length()) {
			String tmp = a;
			a = b;
			b = tmp;
		}
		int lengthA = a.length();
		int lengthB = b.length();
		int indexA = lengthA - 1;
		int indexB = lengthB - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while(indexA >= 0 && indexB >= 0) {
			int sum = a.charAt(indexA) - '0' + b.charAt(indexB) - '0' + carry;
			carry = sum / 2;
			sb.insert(0, sum % 2);
			indexA--;
			indexB--;
		}
		while(indexA >= 0) {
			int sum = a.charAt(indexA) - '0' + carry;
			carry = sum / 2;
			sb.insert(0, sum % 2);
			indexA--;
		}
		if(carry == 1) {
			sb.insert(0, 1);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String a = "1";
		String b = "111";
		System.out.println(addBinary(a, b));
	}
}
