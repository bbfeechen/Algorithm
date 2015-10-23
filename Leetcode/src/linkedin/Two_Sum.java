package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Two_Sum {
	public static List<List<Integer>> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                int index1 = i + 1;
                int index2 = map.get(target - nums[i]);
                if(index1 != index2) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(index1);
                    list.add(index2);
                    result.add(list);
                }
            }
        }
        return result;
    }

	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 0, 1};
		int target = 2;
		List<List<Integer>> res = twoSum(nums, target);
		for(List<Integer> sol : res) {
			for(Integer ind : sol) {
				System.out.print(ind + " ");
			}
			System.out.println();
		}
	}

}
