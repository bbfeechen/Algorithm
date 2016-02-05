package hard;

public class Q214_Shortest_Palindrome {
	public static String shortestPalindrome(String s) {
        int j = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        if(j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        String mid = shortestPalindrome(s.substring(0, j));
        String prefix = new StringBuilder(suffix).reverse().toString();
        return prefix + mid + suffix;
    }
    
    public static void main(String[] args) {
		System.out.println(shortestPalindrome("aacecaaa"));
		System.out.println(shortestPalindrome("abcd"));
	}
}
