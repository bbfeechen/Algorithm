package zenefits;

import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] result = new int[nums.length - k + 1];
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!list.isEmpty() && list.get(0) + k <= i) {
                list.remove(0);
            }
            while(!list.isEmpty() && nums[list.get(list.size() - 1)] <= nums[i]) {
                list.remove(list.size() - 1);
            }
            list.add(i);
            if(i + 1 >= k) {
                result[i + 1 - k] = nums[list.get(0)];
            }
        }
        return result;
    }

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] result = maxSlidingWindow(nums, k);
		for(int num : result) {
			System.out.print(num + " ");
		}
	}
}
