package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q179_Largest_Number {
	public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        boolean isAllZeros = true;
        List<String> list = new ArrayList<String>();
        for(int num : nums) {
            if(num != 0) {
                isAllZeros = false;
            }
            list.add(num + "");
        }
        Collections.sort(list, new StringComparator());
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.insert(0, str);
        }
        if(isAllZeros) {
            return "0";
        }
        return sb.toString();
    }
    
    private static class StringComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return (int)(Long.valueOf(a + b) - Long.valueOf(b + a));
        }
    }

	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));
	}
}
