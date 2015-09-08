package medium;

public class Q162_Find_Peak_Element {
	public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }
        return findPeakElement(nums, 0, nums.length - 1);
    }
    
    private static int findPeakElement(int[] nums, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(mid == 0 && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        if(mid == nums.length - 1 && nums[mid - 1] < nums[mid]) {
            return mid;
        }
        if(mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        if(nums[mid] > nums[mid + 1]) {
            return findPeakElement(nums, start, mid - 1);
        } else {
            return findPeakElement(nums, mid + 1, end);
        }
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		System.out.println(findPeakElement(nums));
	}
}
