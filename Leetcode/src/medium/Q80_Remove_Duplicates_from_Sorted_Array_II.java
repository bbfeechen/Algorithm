package medium;

public class Q80_Remove_Duplicates_from_Sorted_Array_II {
	public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        int repeat = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                size++;
                nums[size] = nums[i];
                repeat = 0;
            } else if(nums[i] == nums[i - 1] && repeat == 0) {
                size++;
                nums[size] = nums[i];
                repeat++;
            }
        }
        return size + 1;
    }

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(nums));
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
