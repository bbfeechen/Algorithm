package medium;

public class Q31_Next_Permutation {
	public static void nextPermutation(int[] nums) {
        if(nums == null) {
            return;
        }
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i + 1] > nums[i]) {
                int j = 0;
                for(j = nums.length - 1; j >= 0; j--) {
                    if(nums[j] > nums[i]) {
                        break;
                    }
                }
                swap(i, j, nums);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }
    
    private static void swap(int src, int dst, int[] nums) {
        int temp = nums[src];
        nums[src] = nums[dst];
        nums[dst] = temp;
    }
    
    private static void reverse(int[] nums, int start, int end) {
        for(int i = start, j = end; i <= j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
