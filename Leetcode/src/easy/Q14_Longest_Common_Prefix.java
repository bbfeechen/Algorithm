package easy;

public class Q14_Longest_Common_Prefix {
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String lcp = strs[0];
        for(int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;
            while(j < str.length() && j < lcp.length()) {
                if(str.charAt(j) == lcp.charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            lcp = lcp.substring(0, j);
        }
        return lcp;
    }

	public static void main(String[] args) {
		String[] strs = {"abcd", "abcdd", "abcde", "abdef"}; 
		System.out.println(longestCommonPrefix(strs));
	}
}
