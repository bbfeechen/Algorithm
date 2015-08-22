package medium;

import java.util.HashMap;
import java.util.Map;

public class Q1_Two_Sum {
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                int index1 = i + 1;
                int index2 = map.get(target - nums[i]);
                if(index1 != index2) {
                    return new int[] {index1, index2};
                }
            }
        }
        return null;
    }

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] res = twoSum(nums, target);
		System.out.println(res[0] + " " + res[1]);
	}

}
