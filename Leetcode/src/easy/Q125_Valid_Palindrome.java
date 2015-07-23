package easy;

public class Q125_Valid_Palindrome {
	public static boolean isPalindrome(String s) {
		if(s == null || s.length() == 0) {
			return true;
		}
		int start = 0;
		int end = s.length() - 1;
		while(start < end) {
			while(start < end && !isValid(s.charAt(start))) {
				start++;
			}
			while(end > start && !isValid(s.charAt(end))) {
				end--;
			}
			if(start == end) {
				break;
			}
			if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	private static boolean isValid(char c) {
		return Character.isDigit(c) || Character.isLetter(c);
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
		s = "race a car";
		System.out.println(isPalindrome(s));
	}
}
