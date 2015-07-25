package hard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Q140_Word_Break_II {
	public static List<String> wordBreak(String s, Set<String> dict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, dict, map);
    }
	
	private static List<String> dfs(String s, Set<String> dict, Map<String, List<String>> map) {
		if(map.containsKey(s)) {
			return map.get(s);
		}
		List<String> result = new ArrayList<String>();
		if(s.length() == 0) {
			return result;
		}
		
		for(int i = 1; i <= s.length(); i++) {
			String prefix = s.substring(0, i);
			if(dict.contains(prefix)) {
				if(i == s.length()) {
					result.add(prefix);
				} else {
					String suffix = s.substring(i);
					List<String> tmp = dfs(suffix, dict, map);
					for(String str : tmp) {
						str = prefix + " " + str;
						result.add(str);
					}
				}
			}
		}
		map.put(s, result);
		return result;
	}
   

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>(){{ add("cat"); add("cats"); add("and"); add("sand"); add("dog"); }};
		List<String> list = wordBreak(s, dict);
		System.out.println(list);
	}
}
