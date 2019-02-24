package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q632_Smallest_Range {
    private static class GroupNum {
        int num;
        int group;
        public GroupNum(int num, int group) {
            this.num = num;
            this.group = group;
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        List<GroupNum> list = new ArrayList<>();
        for (int group = 0; group < nums.size(); group++) {
            for (int num : nums.get(group)) {
                list.add(new GroupNum(num, group));
            }
        }
        Collections.sort(list, new Comparator<GroupNum>() {
            @Override
            public int compare(GroupNum a, GroupNum b) {
                return a.num - b.num;
            }
        });
        int left = 0;
        int right = 0;
        int count = 0;
        int[] groupCount = new int[nums.size()];
        int[] result = new int[2];
        int minRange = Integer.MAX_VALUE;
        while (right < list.size()) {
            GroupNum currNum = list.get(right);
            groupCount[currNum.group]++;
            if (groupCount[currNum.group] == 1) {
                count++;
            }
            while (count >= nums.size()) {
                if (list.get(right).num - list.get(left).num + 1 < minRange) {
                    result[0] = list.get(left).num;
                    result[1] = list.get(right).num;
                    minRange = list.get(right).num - list.get(left).num + 1;
                }
                GroupNum leftNum = list.get(left);
                groupCount[leftNum.group]--;
                if (groupCount[leftNum.group] == 0) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return result;
    }


    public static void main(String[] args) {
        Integer[][] arrays = {{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}};
        List<List<Integer>> nums = new ArrayList<>();
        for (Integer[] array : arrays) {
            nums.add(Arrays.asList(array));
        }
        System.out.println(smallestRange(nums));
    }
}
