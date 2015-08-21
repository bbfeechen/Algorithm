package easy;

public class Q26_Remove_Duplicates_from_Sorted_Array {
	public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[size]) {
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }

	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 2, 2, 3};
		System.out.println(removeDuplicates(nums));
	}

}
