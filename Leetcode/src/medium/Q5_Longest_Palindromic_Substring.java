package medium;

public class Q5_Longest_Palindromic_Substring {
	public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        int max = 0;
        String result = null;
        for(int i = 0; i < s.length(); i++) {
            String str1 = helper(s, i, i);
            String str2 = helper(s, i, i + 1);
            String temp = str1.length() > str2.length() ? str1 : str2;
            if(temp.length() > max) {
                result = temp;
                max = temp.length();
            }
        }
        
        return result;
    }
    
    private static String helper(String s, int start, int end) {
        while(start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
