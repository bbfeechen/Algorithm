package secret;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q288_Unique_Word_Abbreviation {
	public static boolean isUnique(Set<String> dict, String word) {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		for(String str : dict) {
			String abbr = getAbbr(str);
			if(!map.containsKey(abbr)) {
				map.put(abbr, new HashSet<String>());
			}
			map.get(abbr).add(str);
		}
		
		String abbw = getAbbr(word);
		if(map.containsKey(abbw)) {
			Set<String> set = map.get(abbw);
			if(set.size() == 1 && set.contains(word)) {
				return true;
			}
			return false;
		}
		return true;
	}
	
	private static String getAbbr(String str) {
		if(str == null) {
			return "null";
		}
		if(str.length() <= 2) {
			return str;
		}
		return str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1) + "";
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("deer");
		dict.add("door");
		dict.add("cake");
		dict.add("card");
		System.out.println(isUnique(dict, "cane"));
		System.out.println(isUnique(dict, "cart"));
		System.out.println(isUnique(dict, "make"));
		System.out.println(isUnique(dict, "dear"));
	}
}
