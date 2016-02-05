package snapchat;

import java.util.HashMap;
import java.util.Map;

public class Sum2Zero {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, -1, 2, -3, -3, 1, 2}; 
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int currSum = 0;
		for(int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if(currSum == 0) {
				System.out.println(0 + ", " + i);
				return;
			}
			if(map.containsKey(currSum)) {
				System.out.println((map.get(currSum) + 1) + ", " + i);
				return;
			}
			map.put(currSum, i);
		}
		System.out.println("Not Found");
	}
}
