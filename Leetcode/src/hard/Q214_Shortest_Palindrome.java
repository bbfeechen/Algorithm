package hard;

public class Q214_Shortest_Palindrome {
	public String shortestPalindrome(String s) {
        if(s == null || s.length() < 2)
            return s;
        int index = 0;
        for(int i = 0 ; i < s.length()*2-1 ; i++){
            int left = i/2;
            int right = i/2;
            if(i%2 == 1)
                right++;
            if(helper(s, left, right)){
                index = (i%2 == 1 ? right*2 : right*2+1);
            }
        }
        
        return new StringBuilder(s.substring(index)).reverse() + s;
    }
    
    private boolean helper(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(left == -1)
            return true;
        return false;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
