package interview;

import java.util.Scanner;

public class tuneIn {
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
	        
	        res = count_runs(_target);
	        System.out.println(res);
	        
	    }
}
