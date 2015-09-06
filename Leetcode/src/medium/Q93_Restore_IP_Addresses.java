package medium;

import java.util.ArrayList;
import java.util.List;

public class Q93_Restore_IP_Addresses {
	public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        List<String> solution = new ArrayList<String>();
        helper(s, solution, result, 0);
        return result;
    }
    
    private static void helper(String s, List<String> solution, List<String> result, int start) {
        if(solution.size() == 4) {
            if(start != s.length()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for(String str : solution) {
                sb.append(str);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }
        
        for(int i = start; i < s.length() && i <= start + 3; i++) {
            String temp = s.substring(start, i + 1);
            if(isValid(temp)) {
                solution.add(temp);
                helper(s, solution, result, i + 1);
                solution.remove(solution.size() - 1);
            }
        }
    }
    
    private static boolean isValid(String str) {
        int num = Integer.valueOf(str);
        if(str.charAt(0) == '0') {
            return str.equals("0");
        }
        if(num > 0 && num <= 255) {
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
		String s = "25525511135";
		List<String> result = restoreIpAddresses(s);
		for(String solution : result) {
			System.out.print(solution + " ");
		}
	}
}
