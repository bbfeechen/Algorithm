package easy;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Q506_Relative_Ranks {

    public static String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        String[] result = new String[nums.length];
        int count = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            if (count == 1) {
                result[index] = "Gold Medal";
            } else if (count == 2) {
                result[index] = "Silver Medal";
            } else if (count == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = count + "";
            }
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = findRelativeRanks(new int[] {5, 4, 3, 2, 1});
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
