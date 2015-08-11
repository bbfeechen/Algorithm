package easy;

public class Q189_Rotate_Array {
	public static void rotate(int[] nums, int k) {
        if(nums == null || k == 0) {
            return;
        }
        k = k % (nums.length);
        if(k <= 0) {
            return;
        }
        
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private static void reverse(int[] nums, int start, int end) {
        for(int i = start, j = end; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

	public static void main(String[] args) {
		int[] nums = {-1,-100,3,99};
		int k = 3;
		rotate(nums, 3);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
