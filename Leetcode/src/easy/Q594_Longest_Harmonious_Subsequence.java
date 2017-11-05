package easy;

import java.util.HashMap;
import java.util.Map;

public class Q594_Longest_Harmonious_Subsequence {
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key + 1) + map.get(key));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[] {1,3,2,2,5,2,3,7}));
    }
}
