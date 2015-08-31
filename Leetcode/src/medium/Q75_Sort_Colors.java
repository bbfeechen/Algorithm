package medium;

public class Q75_Sort_Colors {
	public static void sortColors(int[] nums) {
        int pr = 0;
        int pb = nums.length - 1;
        int i = 0;
        while(i <= pb) {
            if(nums[i] == 0) {
                swap(pr, i, nums);
                i++;
                pr++;
            } else if(nums[i] == 2) {
                swap(pb, i, nums);
                pb--;
            } else {
                i++;
            }
        }
    }
    
    private static void swap(int src, int dst, int[] nums) {
        int temp = nums[src];
        nums[src] = nums[dst];
        nums[dst] = temp;
    }

	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 2, 1, 2, 0, 1, 1, 2};
		sortColors(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
