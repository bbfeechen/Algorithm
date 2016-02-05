package medium;

class Q300_Longest_Increasing_Subsequence {
	public static int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lengthOfLIS(nums));
	}
}
