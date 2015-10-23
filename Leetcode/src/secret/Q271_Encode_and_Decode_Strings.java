package secret;

import java.util.ArrayList;
import java.util.List;

public class Q271_Encode_and_Decode_Strings {
	// Encodes a list of strings to a single string. 
    public static String encode(List<String> strs) { 
        if(strs == null || strs.size() == 0) return ""; 
        StringBuilder sb = new StringBuilder(); 
        for(String str : strs){ 
            sb.append(str.length()).append("#").append(str).append("#"); 
        } 
          
        return sb.toString(); 
    } 
  
    // Decodes a single string to a list of strings. 
    public static List<String> decode(String s) { 
        List<String> list = new ArrayList<String>(); 
        if(s == null || s.length() ==0) return list; 
          
        int i = 0; 
        int start = 0; 
        while(start < s.length() && (i = s.indexOf("#",start))!= -1){ 
            int len = Integer.parseInt(s.substring(start, i)); 
            i++; 
            String str = s.substring(i, i+len); 
            list.add(str); 
            start = i+len+1; 
        } 
        return list; 
    } 

	public static void main(String[] args) {

	}
}
