package easy;

import java.util.HashSet;
import java.util.Set;

public class Q202_Happy_Number {
	public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(!set.contains(n)) {
            set.add(n);
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int num = 0;
            for(char c : chars) {
                num += (c - '0') * (c - '0'); 
            }
            if(num == 1) {
                return true;
            }
            n = num;
        }
        return false;
    }

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
}
