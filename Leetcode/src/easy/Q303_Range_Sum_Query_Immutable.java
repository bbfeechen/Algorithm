package easy;

public class Q303_Range_Sum_Query_Immutable {
	public class NumArray {
	    private int[] dp;
	    public NumArray(int[] nums) {
	        dp = new int[nums.length];
	        int sum = 0;
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            dp[i] = sum;
	        }
	    }

	    public int sumRange(int i, int j) {
	        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
	    }
	}

	public static void main(String[] args) {
//		int[] nums = {-2, 0, 3, -5, 2, -1};
//		NumArray numArray = new NumArray(nums);
//		numArray.sumRange(0, 1);
//		numArray.sumRange(1, 2);
	}

}
