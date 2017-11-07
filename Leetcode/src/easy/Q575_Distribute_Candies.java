package easy;

import java.util.HashMap;
import java.util.Map;

public class Q575_Distribute_Candies {

    public static int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int candy : candies) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }

        return Math.min(map.keySet().size(), candies.length / 2);
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[] {1, 1, 2, 2, 3, 3}));
        System.out.println(distributeCandies(new int[] {1, 1, 2, 3}));
    }
}
