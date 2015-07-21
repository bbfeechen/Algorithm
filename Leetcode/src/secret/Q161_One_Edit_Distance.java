package secret;

public class Q161_One_Edit_Distance {
	public static boolean isOneEditDistance(String s1, String s2) {
		return helper(s1, s2, 0, 0, 0);
	}
	
	private static boolean helper(String s1, String s2, int i, int j, int distance) {
		while(i < s1.length() && i >= 0 && j < s2.length() && j >= 0) {
			if(s1.charAt(i) != s2.charAt(j)) {
				distance++;
				if(distance > 1) {
					return false;
				}
				return helper(s1, s2, i + 1, j, distance) || helper(s1, s2, i, j + 1, distance) ||
						helper(s1, s2, i + 1, j + 1, distance);
			} else {
				return helper(s1, s2, i + 1, j + 1, distance);
			}
		}
		if(distance == 1) {
			return (i == s1.length() && j == s2.length());
		} else {
			return (Math.abs(s1.length() - s2.length()) == 1);
		}
	}

	public static void main(String[] args) {
		boolean res = isOneEditDistance("abcdefg", "abcdefgh");
		if(res) {
			System.out.println("is one edit distance");
		} else {
			System.out.println("is not one edit distance");
		}
	}
}
