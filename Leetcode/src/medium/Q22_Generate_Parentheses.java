package medium;

import java.util.ArrayList;
import java.util.List;

public class Q22_Generate_Parentheses {
	public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n == 0) {
            return result;
        }
        helper(result, "", 0, 0, n);
        return result;
    }
    
    private static void helper(List<String> result, String solution, int leftNum, int rightNum, int n) {
        if(solution.length() == 2 * n) {
            result.add(solution);
            return;
        }
        if(leftNum < n) {
            helper(result, solution + "(", leftNum +  1, rightNum, n);
        }
        if(rightNum < leftNum) {
            helper(result, solution + ")", leftNum, rightNum + 1, n);
        }
    }

	public static void main(String[] args) {
		List<String> result = generateParenthesis(3);
		for(String str : result) {
			System.out.print(str + " ");
		}
	}
}
