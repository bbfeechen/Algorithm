package medium;

import java.util.ArrayList;
import java.util.List;

public class Q241_Different_Ways_to_Add_Parentheses {
	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();
		if(input == null || input.length() == 0) {
			return result;
		}
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for(int j : left) {
					for(int k : right) {
						if(input.charAt(i) == '+') {
							result.add(j + k);
						} else if(input.charAt(i) == '-') {
							result.add(j - k);
						} else if(input.charAt(i) == '*') {
							result.add(j * k);
						}
					}
				}
			}
		}
		if(result.isEmpty()) {
			result.add(Integer.valueOf(input));
		}
		return result;
	}

	public static void main(String[] args) {
		String input = "2*3-4*5";
		List<Integer> result = diffWaysToCompute(input);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
