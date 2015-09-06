package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17_Letter_Combinations_of_a_Phone_Number {
	public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        
        StringBuilder sb = new StringBuilder();
        helper(result, map, sb, digits);
        return result;
    }
    
    private static void helper(List<String> result, Map<Character, char[]> map, StringBuilder sb, String digits) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for(char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(result, map, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

	public static void main(String[] args) {
		String digits = "23";
		List<String> result = letterCombinations(digits);
		for(String str : result) {
			System.out.print(str + " ");
		}
	}
}
