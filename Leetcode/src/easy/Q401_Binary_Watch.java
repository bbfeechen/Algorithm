package easy;

import java.util.ArrayList;
import java.util.List;

public class Q401_Binary_Watch {
    public static List<String> readBinaryWatch(int num) {
        final int[] arr = {1,2,4,8,1,2,4,8,16,32};
        List<String> res = new ArrayList<>();
        helper(res, arr, num, 0, 0, 0);
        return res;
    }
    private static void helper(List<String> res, int[] arr, int n, int hr, int min, int index) {
        if (n < 0 || hr >= 12 || min >= 60) return;
        if (n == 0) {
            String time = hr + ":" + (min > 9 ? min : "0" + min);
            res.add(time);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i < 4) helper(res, arr, n - 1, hr + arr[i], min, i + 1);
            else helper(res, arr, n - 1, hr, min + arr[i], i + 1);
        }
    }

    public static void main(String[] args) {
        List<String> result = readBinaryWatch(2);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
