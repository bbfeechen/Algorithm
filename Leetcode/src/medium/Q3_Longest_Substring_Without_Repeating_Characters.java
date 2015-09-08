package medium;

import java.util.HashSet;
import java.util.Set;

public class Q3_Longest_Substring_Without_Repeating_Characters {
	public static int lengthOfLongestSubstring(String s) {
        int leftBound = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                while(leftBound < s.length() && s.charAt(leftBound) != c) {
                    set.remove(s.charAt(leftBound));
                    leftBound++;
                }
                leftBound++;
            } else {
                set.add(c);
                maxLen = Math.max(maxLen, i - leftBound + 1);
            }
        }
        return maxLen;
    }

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
