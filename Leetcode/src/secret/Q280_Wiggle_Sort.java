package secret;

public class Q280_Wiggle_Sort {
	// if nums[1] < nums[0], swap them, so nums[1] > nums[0].
	// Then if nums[2] > nums[1], swap them.
	// Since nums[2] > nums[1] > nums[0], so we can swap nums[2] and num[1] safely.
	public static void wiggleSort(int[] nums) {
		for(int i = 1; i < nums.length; i++){
            if((i % 2 == 1 && nums[i] < nums[i-1]) || (i % 2 == 0 && nums[i] > nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
    }

	public static void main(String[] args) {
		int[] nums = {3, 5, 2, 1, 6, 4};
		wiggleSort(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
