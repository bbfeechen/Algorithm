package medium;

public class Q209_Minimum_Size_Subarray_Sum {
	public static int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(solve(mid, s, nums)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
    
    private static boolean solve(int mid, int s, int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(i >= mid) {
                sum -= nums[i - mid];
            }
            if(sum >= s) {
                return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, nums));
	}
}
