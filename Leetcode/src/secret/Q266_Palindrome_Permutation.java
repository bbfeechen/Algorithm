package secret;

import java.util.HashMap;
import java.util.Map;

//Given a string, determine if a permutation of the string could form a palindrome.
//For example,
//"code" -> False, "aab" -> True, "carerac" -> True.

public class Q266_Palindrome_Permutation {
	public static boolean canPermutePalindrome(String s) {
		if(s == null || s.length() <= 1) {
			return true;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		boolean hasOdd = false;
		for(int count : map.values()) {
			if(count % 2 == 1) {
				if(hasOdd) {
					return false;
				} else {
					hasOdd = true;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "code";
		System.out.println(canPermutePalindrome(s));
		s = "aab";
		System.out.println(canPermutePalindrome(s));
		s = "carerac";
		System.out.println(canPermutePalindrome(s));
	}
}
