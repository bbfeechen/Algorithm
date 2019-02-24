package medium;

import java.util.Arrays;

public class Q359_3Sum_Smaller {
    public static int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (end > start && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (sum < target) {
                    start++;
                    result++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[] {-2,0,1,3}, 2));
    }
}
