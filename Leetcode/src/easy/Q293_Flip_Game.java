package easy;

import java.util.ArrayList;
import java.util.List;

//	You are playing the following Flip Game with your friend: 
//	Given a string that contains only these two characters:+ and -, 
//	you and your friend take turns to flip two consecutive "++" into "--". 
//	
//	The game ends when a person can no longer make a move and therefore the other person will be the winner.
//	Write a function to compute all possible states of the string after one valid move.
//	For example, given s = "++++", after one move, it may become one of the following states:
//	[
//	  "--++",
//	  "+--+",
//	  "++--"
//	]
//	If there is no valid move, return an empty list [].

public class Q293_Flip_Game {
	public static List<String> getFlipResult(String s) {  
	    List<String> result = new ArrayList<String>();
	    if(s.length() <= 1) {
	    	return result;
	    }
	    dfs(s, result, 0);
	    return result;
	}  
	
	public static void dfs(String s, List<String> result, int start) {  
	    for(int i = start; i < s.length() - 1; i++) {
	    	if(s.charAt(i) == '+' && s.charAt(i) == s.charAt(i + 1)) {
	    		String str = s.substring(0, i) + "--" + s.substring(i + 2);
	    		result.add(str);
	    	} else {
	    		dfs(s, result, i + 1);
	    	}
	    } 
	} 

	public static void main(String[] args) {
		String[] testcase = {"+","-","++","--","+++","++++","+--+","-+-+","+-+-"};  
	    for(int i = 0; i < testcase.length; i++) {  
	        System.out.println(getFlipResult(testcase[i]));  
	    }
	}
}
