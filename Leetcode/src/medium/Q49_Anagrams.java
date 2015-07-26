package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49_Anagrams {
	public static List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if(strs == null || strs.length == 0) {
            return result;
        }
        
        Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        for(String str : strs) {
            int key = getHash(str);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for(ArrayList<String> list : map.values()) {
            if(list.size() > 1) {
                result.addAll(list);
            }
        }
        return result;
        
    }
    
    private static int getHash(String str) {
        int[] count = new int[26];
        for(char c : str.toCharArray()) {
        	count[c - 'a']++;
        }
        
        int a = 3, b = 5, hash = 0;
        for(int num : count) {
        	hash = hash * a + num;
            a = a * b;
        }
        return hash;
    }
    
    public static void main(String[] args) {
    	String[] strs = {"", ""};
    	List<String> result = anagrams(strs);
    	for(String str : result) {
    		if(str != null && str.length() == 0) {
    			System.out.print("# ");
    		} else {
    			System.out.print(str + " ");
    		}
    	}
    }
}
