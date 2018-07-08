package medium;

import java.util.ArrayList;
import java.util.List;

public class Q163_Missing_Ranges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long next = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) {
                continue;
            }
            if (nums[i] == next) {
                next++;
                continue;
            }
            String range = getRange(next, nums[i] - 1);
            result.add(range);
            next = (long) nums[i] + 1;
        }
        if (next <= upper) {
            result.add(getRange(next, upper));
        }
        return result;
    }

    private static String getRange(long lo, long hi) {
        return lo == hi ? String.valueOf(lo) : (String.valueOf(lo) + "->" + String.valueOf(hi));
    }

    public static void main(String[] args) {
        System.out.println(findMissingRanges(new int[] {2147483647}, 0, 2147483647));
    }
}
