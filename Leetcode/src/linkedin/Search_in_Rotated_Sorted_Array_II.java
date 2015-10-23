package linkedin;

public class Search_in_Rotated_Sorted_Array_II {
	public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return true;
            } 
            
            if(nums[start] < nums[mid]) {
                if(target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(nums[start] > nums[mid]) {
                if(target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start++;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 3, 5, 6, 9, 10};
		System.out.println(search(nums, 6));
	}
}
