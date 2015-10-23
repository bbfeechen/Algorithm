package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class groupon_stringcombination {
	public static List<String> combination(String s) {
		List<String> result = new ArrayList<String>();
		String solution = "";
		dfs(result, solution, s);
		return result;
	}
	
	private static void dfs(List<String> result, String solution, String s) {
		if(solution.length() == s.length()) {
			result.add(new String(solution));
			return;
		}
		for(int i = 0; i < s.length(); i++) {
			if(solution.contains(s.charAt(i) + "")) {
                continue;
            }
			solution += s.charAt(i);
			dfs(result, solution, s);
			solution = solution.substring(0, solution.length() - 1);
		}
	}

	public static void main(String[] args) {
		String s = "abcd";
		List<String> result = combination(s);
		for(String str : result) {
			System.out.print(str + " ");
		}
	}
}
