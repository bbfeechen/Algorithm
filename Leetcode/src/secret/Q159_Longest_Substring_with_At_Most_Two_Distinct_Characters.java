package secret;

import java.util.HashMap;
import java.util.Map;

public class Q159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
	public static int lengthOfLongestSubstringTwoDistinct(String s) { 
		int start = 0;
		int maxLen = 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.size() == 2 && !map.containsKey(c)) {
				int minLast = s.length();
				char charEndsMostLeft = ' ';
				for(char ch : map.keySet()) {
					int last = map.get(ch);
					if(last < minLast) {
						minLast = last;
						charEndsMostLeft = c;
					}
				}
				start = minLast + 1;
			}
			map.put(c, i);
			maxLen = Math.max(maxLen, i - start + 1);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		String str = "ecebaccccabecd";
		int len = lengthOfLongestSubstringTwoDistinct(str);
		System.out.println(len);
	}
}
