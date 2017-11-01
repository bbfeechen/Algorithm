package easy;

import java.util.Arrays;

public class Q561_Array_Partition_I {

    public static int arrayPairSum(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }
}
