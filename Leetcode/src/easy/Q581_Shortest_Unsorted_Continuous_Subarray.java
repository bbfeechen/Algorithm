package easy;

public class Q581_Shortest_Unsorted_Continuous_Subarray {
    public static int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] < nums[i - 1] && nums[i] < min) {
                min = nums[i - 1];
            }
            if (i < nums.length - 1 && nums[i] > nums[i + 1] && nums[i] > max) {
                max = nums[i + 1];
            }
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                start = i;
            }
            if (nums[i] >= max) {
                end = i;
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[] {2, 1}));
    }
}
