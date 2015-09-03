package interview;

public class ixl_learning_2 {
	public static int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] < nums.length && nums[i] != (i + 1)) {
                int temp = nums[nums[i] - 1];
                if(temp == nums[i]) {
                    break;
                }
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

	public static void main(String[] args) {
		int[] nums = {3,4,-1,1};
		System.out.println(firstMissingPositive(nums));
	}
}
