import java.util.Arrays;


public class Q1_3 {
	public static void main(String[] args) {
        String s = "abcd";
        String t = "dbca";
        System.out.println(permutation(s, t));
	}
	
	private static boolean permutation(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	private static String sort(String s) {
		char[] array = s.toCharArray();
		Arrays.sort(array);
		return new String(array);
	}
}
