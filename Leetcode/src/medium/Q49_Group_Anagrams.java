package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49_Group_Anagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Arrays.sort(strs);
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for(String str : strs) {
            int hash = getHash(str);
            if(!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }
            map.get(hash).add(str);
        }
        for(List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
    
    private static int getHash(String str) {
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        int a = 3, b = 5;
        int hash = 0;
        for(int i : count) {
            a = a * b;
            hash += i * a + b;
        }
        return hash;
    }
    
    public static void main(String[] args) {
    	String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    	List<List<String>> result = groupAnagrams(strs);
    	for(List<String> list : result) {
    		System.out.print("[");
    		for(String str : list) {
    			System.out.print(str + " ");
    		}
    		System.out.print("]");
    	}
    }
}
