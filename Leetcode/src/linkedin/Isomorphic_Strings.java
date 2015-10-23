package linkedin;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings {
	public static boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        
        int length = s.length();
        for(int i = 0; i < length; i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if(map1.containsKey(ss) || map2.containsKey(tt)) {
                if(map1.containsKey(ss)) {
                    char st = map1.get(ss);
                    if(tt != st) {
                        return false;
                    }
                }
                if(map2.containsKey(tt)) {
                    char ts = map2.get(tt);
                    if(ss != ts) {
                        return false;
                    }
                }
            } else {
                map1.put(ss, tt);
                map2.put(tt, ss);
            }
        }
        return true;
	}

	public static void main(String[] args) {
		String s = "egg";
		String t = "add";
		System.out.println(isIsomorphic(s, t));

		s = "foo";
		t = "bar";
		System.out.println(isIsomorphic(s, t));
		
		s = "paper";
		t = "title";
		System.out.println(isIsomorphic(s, t));
	}

}
