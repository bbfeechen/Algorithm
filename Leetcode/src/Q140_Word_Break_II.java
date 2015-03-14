import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Q140_Word_Break_II {
	public static List<String> wordBreak(String s, Set<String> dict) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s,dict,map);
    }
    
    public static ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        if(memo.containsKey(s)) return memo.get(s);
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if(n <= 0) return result;
        for(int len = 1; len <= n; ++len) {
            String subfix = s.substring(0,len);
            if(dict.contains(subfix)) {
                if(len == n) {
                    result.add(subfix);
                } else {
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
                    for(String item:tmp) {
                        item = subfix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }

	public static void main(String[] args) {
		String s = "catsanddoge";
		Set<String> dict = new HashSet<String>(){{ add("cat"); add("cats"); add("and"); add("sand"); add("dog"); }};
		List<String> list = wordBreak(s, dict);
		System.out.println(list);
	}
}
