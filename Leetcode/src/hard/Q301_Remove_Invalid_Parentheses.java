package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Q301_Remove_Invalid_Parentheses {
	public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null) {
            return result;
        }
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        
        queue.offer(s);
        visited.add(s);
        
        boolean found = false;
        while(!queue.isEmpty()) {
            String str = queue.poll();
            if(isValid(str)) {
                result.add(str);
                // Remove the minimum number 
                found = true;
            }
            if(found) {
                continue;
            }
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }
                String t = str.substring(0, i) + str.substring(i + 1);
                if(!visited.contains(t)) {
                    queue.offer(t);
                    visited.add(t);
                }
            }
        }
        return result;
    }
    
    private static boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                count++;
            } else if(c == ')') {
                count--;
            }
            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }

	public static void main(String[] args) {
		String s = "(a)())()";
		List<String> result = removeInvalidParentheses(s);
		for(String str : result) {
			System.out.print(str + " ");
		}
	}
}
