package medium;

public class Q153_Find_Minimum_in_Rotated_Sorted_Array {
	public static int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }
    
    private static int findMin(int[] nums, int start, int end) {
        if(start >= end) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        if(mid < end && nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }
        if(mid > start && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        if(nums[mid] < nums[end]) {
            return findMin(nums, start, mid - 1);
        } else {
            return findMin(nums, mid + 1, end);
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(findMin(nums));
	}
}
