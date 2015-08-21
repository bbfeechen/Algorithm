package easy;

import java.util.HashMap;

public class Q13_Roman_to_Integer {
	public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = map.get(s.charAt(s.length() - 1));
        for(int i = s.length() - 2; i >= 0; i--) {
            if(map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(romanToInt("VI"));
		System.out.println(romanToInt("IX"));
	}
}
