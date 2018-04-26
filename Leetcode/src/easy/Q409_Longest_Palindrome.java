package easy;

import java.util.HashMap;
import java.util.Map;

public class Q409_Longest_Palindrome {
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        boolean hasOdd = false;
        for (int value : map.values()) {
            if (value % 2 == 0) {
                count += value;
            } else {
                count += value - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? count + 1 : count;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
