package medium;

import java.util.ArrayList;
import java.util.List;

public class Q22_Generate_Parentheses {
	public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n == 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }
    
    private static void helper(List<String> result, String solution, int leftNum, int rightNum) {
        if(leftNum == 0 && rightNum == 0) {
            result.add(solution);
            return;
        }
        if(leftNum > 0) {
            helper(result, solution + "(", leftNum - 1, rightNum);
        }
        if(rightNum > 0 && rightNum > leftNum) {
            helper(result, solution + ")", leftNum, rightNum - 1);
        }
        return;
    }

	public static void main(String[] args) {
		List<String> result = generateParenthesis(3);
		for(String str : result) {
			System.out.print(str + " ");
		}
	}
}
