package square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSumSpecial {
	public static class Pair {
		int left;
		int right;
		public Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
		
		@Override
		public int hashCode() {
			return left * right;
		}
		
		@Override
		public boolean equals(Object other) {
			return ((this.left == ((Pair)other).left && this.right == ((Pair)other).right) || (
					this.right == ((Pair)other).left && this.left == ((Pair)other).right));
		}
	}
	
	public static List<Pair> twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set<Pair> set = new HashSet<Pair>();
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                int index1 = i + 1;
                int index2 = map.get(target - nums[i]);
                if(index1 != index2) {
                	Pair pair = new Pair(index1, index2);
                    set.add(pair);
                }
            }
        }
        return new ArrayList<Pair>(set);
		
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 0};
		List<Pair> res = twoSum(nums, 2);
		for(Pair pair : res) {
			System.out.println(pair.left + " " + pair.right);
		}
	}
}
