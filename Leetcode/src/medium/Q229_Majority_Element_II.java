package medium;

import java.util.ArrayList;
import java.util.List;

public class Q229_Majority_Element_II {
	public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        int count1 = 0;
        int count2 = 0;
        int num1 = 0;
        int num2 = 0;
        
        for(int num : nums) {
            if(count1 == 0) {
                num1 = num;
            }
            if(count2 == 0 && num != num1) {
                num2 = num;
            }
            if(num == num1) {
                count1++;
            } else if(num == num2) {
                count2++;
            } else if(count1 != 0 && count2 != 0 && num != num1 && num != num2) {
                count1--;
                count2--;
            }
        }
        if(moreThanThird(num1, nums)) {
            result.add(num1);
        }
        if(moreThanThird(num2, nums) && num1 != num2) {
            result.add(num2);
        }
        return result;
    }
    
    private static boolean moreThanThird(int num1, int[] nums) {
        int count = 0;
        for(int num : nums) {
            if(num == num1) {
                count++;
            }
        }
        if(count > nums.length / 3) {
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
