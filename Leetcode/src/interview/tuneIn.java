package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tuneIn {
	static int count_runs2(String target) {
        if(target == null || target.length() == 0) {
            return 0;
        }
        List<Character> list = new ArrayList<Character>();
        for(int i = 0; i < target.length(); i++) {
            char c = Character.toLowerCase(target.charAt(i));
            if(Character.isAlphabetic(c)) {
                list.add(c);
            }
        }
        if(list.size() == 0) {
        	return 0;
        }
        char prev = list.get(0);
        int index = 1;
        int count = 0;
        while(index < list.size()) {
        	char curr = list.get(index);
        	if(curr == prev) {
        		prev = curr;
        		count++;
        		index++;
            	while(index < list.size() && list.get(index) == prev) {
            		index++;
            	}
        	} else {
        		prev = curr;
        		index++;
        	}
        }
        
        return count;
    }
	
	static int count_runs(String target) {
        if(target == null || target.length() == 0) {
            return 0;
        }
        char[] chars = target.toCharArray();
        int count = 0;
        char prev = 0;
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(Character.isAlphabetic(c)) {
                prev = c;
                int add = 0;
                int j = i + 1;
                for(; j < chars.length; j++) {
                    char curr = chars[j];
                    if(Character.isAlphabetic(curr)) {
	                    if(Character.toLowerCase(curr) == Character.toLowerCase(prev)) {
	                        add = 1;
	                    } else {
	                        break;
	                    }
                    }
                }
                count += add;
                i = j - 1;
            }
        }
        return count;
    }

		public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int res;
	        String _target;
	        _target = in.nextLine();
	        
	        res = count_runs2(_target);
	        System.out.println(res);
	        
	    }
}
