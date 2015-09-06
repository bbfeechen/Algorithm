package medium;

public class Q35_Search_Insert_Position {
	public static int searchInsert(int[] nums, int target) {
        if(nums[0] > target) {
            return 0;
        }
        if(nums[nums.length - 1] < target) {
            return nums.length;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] < target && target < nums[mid + 1]) {
                return mid + 1;
            }
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		System.out.println(searchInsert(nums, 5));
	}
}
