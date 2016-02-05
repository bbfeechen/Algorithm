package snapchat;

import java.util.HashMap;
import java.util.Map;

public class MaxFormula {
	public static double findMax(double[] nums, int start, int end, Map<String, Double> map) {
		if(start >= nums.length) {
			return 0.0;
		}
		if(start == end) {
			return nums[start];
		}
		String key = start + " " + end;
		if(map.containsKey(key)) {
			return map.get(key);
		}
		
		double max = Integer.MIN_VALUE;
		for(int i = start; i < end; i++) {
			double left = findMax(nums, start, i, map);
			double right = findMax(nums, i + 1, end, map);
			double result = Math.max(left + right, left * right);
			max = Math.max(max, result);
		}
		map.put(key, max);
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] nums = {1, 2, 3, 1};
		double max = findMax(nums, 0, nums.length - 1, new HashMap<String, Double>());
		System.out.println(max);
	}
}
