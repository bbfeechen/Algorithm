package linkedin;
import java.util.HashMap;

//Firstly, we will move the “end” pointer right, until we find all characters. 
//There may be duplicate characters in string T. 
//So I use a HashMap to save the number of each characters in string T. 
//
//Another HashMap is used to save the number of characters we found. 
//When we move pointer “end”, we will check if the number of this character is smaller than we need to found. 
//If it is, we will increase one to a total counter and increase one to the number of this character. 
//Otherwise only the number of this character is increased.
//
//When the total counter equals to length of T, we know that we have found all characters. 
//Now we can move the “start” pointer as right as possible. 
//We can move it when it pointing to a character that is not in T, or even it is in T, 
//but the number of this character is larger than the number we need to find. In other words, 
//we move “start” pointer when the substring from “start” to “end” does contains all characters in T.
//
//We can compare the value end–start+1, which is the length of a substring that contains 
//all characters in T, to the minimum length. If it’s shorter, we can update the minimum length.

public class Minimum_Window_Substring {
	public static String minWindow(String S, String T) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (!dict.containsKey(c))
                dict.put(c, 1);
            else
                dict.put(c, dict.get(c) + 1);
        }
        HashMap<Character, Integer> found = new HashMap<>();
        int foundCounter = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        String minWindow = "";
        while (end < S.length()) {
            char c = S.charAt(end);
            if (dict.containsKey(c)) {
                if (found.containsKey(c)) {
                    if (found.get(c) < dict.get(c))
                        foundCounter++;
                    found.put(c, found.get(c) + 1);
                } else {
                    found.put(c, 1);
                    foundCounter++;
                }
            }
            if (foundCounter == T.length()) {
                //When foundCounter equals to T.length(), in other words, found all characters.
                char sc = S.charAt(start);
                while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
                    if (found.containsKey(sc) && found.get(sc) > dict.get(sc))
                        found.put(sc, found.get(sc) - 1);
                    start++;
                    sc = S.charAt(start);
                }
                if (end - start + 1 < min) {
                    minWindow = S.substring(start, end + 1);
                    min = end - start + 1;
                }
            }
            end++;
        }
        return minWindow;
    }
    
	public static void main(String[] args) {
		String S = "ADOBECODEBANC", T = "ABC";
		System.out.println(minWindow(S, T));
	}

}
