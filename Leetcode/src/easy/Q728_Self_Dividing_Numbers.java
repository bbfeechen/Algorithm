package easy;

import java.util.ArrayList;
import java.util.List;

public class Q728_Self_Dividing_Numbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNum(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isSelfDividingNum(int num) {
        int orig = num;
        while (num != 0) {
            int digit = num & 0x01;
            if (digit == 0) {
                return false;
            }
            if (orig % digit != 0) {
                return false;
            }
            num >>>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }
}
