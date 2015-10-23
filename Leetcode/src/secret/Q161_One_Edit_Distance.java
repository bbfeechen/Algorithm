package secret;

//Problem Description:
//
//Given two strings S and T, determine if they are both one edit distance apart.
//
//To solve this problem, you first need to know what is edit distance. You may refer to 
//this wikipedia article for more information.
//
//For this problem, it implicitly assumes to use the classic Levenshtein distance, 
//which involvesinsertion, deletion and substitution operations and all of them are of 
//the same cost. Thus, if Sis one edit distance apart from T, T is automatically one edit distance apart from S.

public class Q161_One_Edit_Distance {
	// http://www.danielbit.com/blog/puzzle/leetcode/leetcode-one-edit-distance
	public static boolean isOneEditDistance(String s, String t) {
		int m = s.length(), n = t.length();
        if(m > n) {
        	return isOneEditDistance(t, s);
        }
        if( n - m > 1) {
        	return false;
        }
        int i = 0, shift = n - m;
        while(i < m && s.charAt(i) == t.charAt(i)) {
        	++i;
        }
        if(i == m) {
        	return shift > 0; // if two string are the same (shift==0), return false 
        }
        if(shift == 0) {
        	i++; // if n==m skip current char in s (modify operation in s)
        }
        while(i < m && s.charAt(i) == t.charAt(i + shift)) {
        	i++; // use shift to skip one char in t
        }
        return i == m;
	}

	public static void main(String[] args) {
		boolean res = isOneEditDistance("abcdefg", "abcdefgh");
		if(res) {
			System.out.println("is one edit distance");
		} else {
			System.out.println("is not one edit distance");
		}
	}
}
