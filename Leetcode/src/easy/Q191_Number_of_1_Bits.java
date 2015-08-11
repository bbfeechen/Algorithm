package easy;

import java.util.HashMap;
import java.util.Map;

public class Q191_Number_of_1_Bits {
	public static int hammingWeight(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 2);
        map.put(4, 1);
        map.put(5, 2);
        map.put(6, 2);
        map.put(7, 3);
        map.put(8, 1);
        map.put(9, 2);
        map.put(10, 2);
        map.put(11, 3);
        map.put(12, 2);
        map.put(13, 3);
        map.put(14, 3);
        map.put(15, 4);
        
        int count = 0;
        while(n != 0) {
            int num = (n & 0x0F);
            count += map.get(num);
            n >>>= 4;
        }
        return count;
    }

	public static void main(String[] args) {
		System.out.println(hammingWeight(31));
		System.out.println(hammingWeight(512));
	}
}
