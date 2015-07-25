package medium;
import java.util.ArrayList;


public class Q131_Palindrome_Partitioning {
	public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0) {
            return result;
        }
        ArrayList<String> solution = new ArrayList<String>();
        helper(result, solution, s, 0);
        return result;
    }
    
    private static void helper(ArrayList<ArrayList<String>> result, ArrayList<String> solution, String s, int index) {
        if(index == s.length()) {
            result.add(new ArrayList<String>(solution));
            return;
        }
        
        for(int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if(!isPalindrome(str)) {
                continue;
            }
            solution.add(str);
            helper(result, solution, s, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
    
    private static boolean isPalindrome(String str) {
        if(str == null) {
            return true;
        }
        int start = 0, end = str.length() - 1;
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            } 
            start++;
            end--;
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
