package secret;

import java.util.Arrays;

public class Q259_3Sum_Smaller {
	public static int threeSumSmaller(int[] nums, int target) {
        // 先将数组排序 
        Arrays.sort(nums);
        int cnt = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                // 如果三个数的和大于等于目标数，那将尾指针向左移
                if(sum >= target){
                    right--;
                // 如果三个数的和小于目标数，那将头指针向右移
                } else {
                    // right - left个组合都是小于目标数的
                    cnt += right - left;
                    left++;
                }
            }
        }
        return cnt;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
