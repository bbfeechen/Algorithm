package secret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//Given a string, we can "shift" each of its letter to its successive letter, 
//for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
//"abc" -> "bcd" -> ... -> "xyz"
//Given a list of strings which contains only lowercase alphabets, group all 
//strings that belong to the same shifting sequence.
//For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
//Return:
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
//Note: For the return value, each inner list's elements must follow the lexicographic order.

public class Q249_Group_Shifted_Strings {
	public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return result;
        }
         
        Arrays.sort(strings, new LexComparator());
        Map<String, List<String>> map = new HashMap<String, List<String>>();
         
        for (String s : strings) {
            StringBuffer sb = new StringBuffer();
            int distance = s.charAt(0) - 'a';
            for (int i = 0; i < s.length(); i++) {
                int val = s.charAt(i) - distance;
                val = val < 'a' ? val + 26 : val;
                char ori = (char) val;
                sb.append(ori);
            }
            String original = sb.toString();
            if (!map.containsKey(original)) {
                map.put(original, new ArrayList<String>());
            }
            map.get(original).add(s);
        }
         
        // Iterate the map
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            result.add((List<String>) entry.getValue());
        }
         
        return result;
    }
     
    private static class LexComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
             
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    return a.charAt(i) - b.charAt(i);
                }
            }
            return 0;
        }
    }

	public static void main(String[] args) {
		String[] strs = {"abc", "bcd", "adef", "xyz", "az", "ba", "a", "z"};
		System.out.println(groupStrings(strs));
	}
}
