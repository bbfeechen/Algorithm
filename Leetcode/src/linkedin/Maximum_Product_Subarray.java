package linkedin;

public class Maximum_Product_Subarray {
	public static int maxProduct(int[] nums) {
        int localMin = nums[0];
        int localMax = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int localMinCopy = localMin;
            localMin = Math.min(Math.min(localMin * nums[i], localMax * nums[i]), nums[i]);
            localMax = Math.max(Math.max(localMinCopy * nums[i], localMax * nums[i]), nums[i]);
            max = Math.max(max, localMax);
        }
        return max;
    }

	public static void main(String[] args) {
		int[] nums = {2,3,-2,4};
		System.out.println(maxProduct(nums));
	}
}
