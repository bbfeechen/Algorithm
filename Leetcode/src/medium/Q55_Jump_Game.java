package medium;

public class Q55_Jump_Game {
	public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
            if(dp[i] < 0) {
                return false;
            }
        }
        return dp[nums.length - 1] >= 0;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {2,3,1,1,4};
		System.out.println(canJump(nums1));
		int[] nums2 = {3,2,1,0,4};
		System.out.println(canJump(nums2));
	}
}
