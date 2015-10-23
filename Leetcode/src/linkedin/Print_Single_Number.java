package linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Print_Single_Number {
	public static void printSingleNum(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums) {
			if(!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			int key = (int)entry.getKey();
			int val = (int)entry.getValue();
			if(val == 1) {
				System.out.print(key + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 2, 3};
		printSingleNum(nums);
	}
}
