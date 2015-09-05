package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q187_Repeated_DNA_Sequences {
	public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            int hash = getHash(str);
            if(!map.containsKey(hash)) {
                map.put(hash, 1);
            } else {
                map.put(hash, map.get(hash) + 1);
                if(map.get(hash) == 2) {
                    result.add(str);
                }
            }
        }
        return result;
    }
    
    private static int getHash(String str) {
        int hash = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            int val = 0;
            char c = str.charAt(i);
            switch(c) {
                case 'A':
                    val |= 0;
                    break;
                case 'T':
                    val |= 1;
                    break;
                case 'C':
                    val |= 2;
                    break;
                case 'G':
                    val |= 3;
                    break;
            }
            hash |= val;
            hash <<= 2;
        }
        return hash;
    }

	public static void main(String[] args) {
		String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> result = findRepeatedDnaSequences(str);
		for(String s : result) {
			System.out.print(s + " ");
		}
	}
}
