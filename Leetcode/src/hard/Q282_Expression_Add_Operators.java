package hard;

import java.util.ArrayList;
import java.util.List;

public class Q282_Expression_Add_Operators {
	public static List<String> addOperators(String num, int target) {
        //http://www.cnblogs.com/grandyang/p/4814506.html
        List<String> result = new ArrayList<String>();
        dfs(result, "", num, target, 0, 0, 0);
        return result;
    }
    
    private static void dfs(List<String> result, String solution, String num, int target, int pos, long sum, long lastNum) {
        int len = num.length();
        if(pos == len && sum == target) {
            result.add(solution);
            return;
        }
        if(pos >= len) {
            return;
        }
        for(int i = pos; i < len; i++) {
            if(i != pos && num.charAt(pos) == '0') {
                break;
            }
            long currNum = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0) {
                dfs(result, solution + "" + currNum, num, target, i + 1, currNum, currNum);
            } else {
                dfs(result, solution + "+" + currNum, num, target, i + 1, sum + currNum, currNum);
                dfs(result, solution + "-" + currNum, num, target, i + 1, sum - currNum, -currNum);
                dfs(result, solution + "*" + currNum, num, target, i + 1, sum - lastNum + currNum * lastNum, currNum * lastNum);
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
