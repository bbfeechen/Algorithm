package medium;

public class Q268_Missing_Number {
	public static int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }

	public static void main(String[] args) {
		int[] nums = {0, 1, 3};
		System.out.println(missingNumber(nums));
	}
}
