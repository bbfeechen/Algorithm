package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//	Given a string, determine if a permutation of the string could form a palindrome.
//	For example,
//	"code" -> False, "aab" -> True, "carerac" -> True.

public class Q266_Palindrome_Permutation {
	public static boolean canPermutePalindrome(String s) {
		if(s == null || s.length() == 0) {
			return true;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		Iterator itor = map.entrySet().iterator();
		int odd = 0;
		while(itor.hasNext()) {
			Map.Entry entry = (Map.Entry)itor.next();
			if((int)entry.getValue() % 2 != 0) {
				odd++;
			}
		}
		if(s.length() == 0) {
			return odd == 0;
		} else {
			return odd == 1;
		}
	}

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("code"));
		System.out.println(canPermutePalindrome("aab"));
		System.out.println(canPermutePalindrome("carerac"));
	}
}
