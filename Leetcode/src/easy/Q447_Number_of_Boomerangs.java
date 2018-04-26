package easy;

import java.util.HashMap;
import java.util.Map;

public class Q447_Number_of_Boomerangs {
    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int d = distance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (int value : map.values()) {
                count += value * (value - 1);
            }
            map.clear();
        }
        return count;
    }

    private static int distance(int[] p1, int[] p2) {
        return Math.abs((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1,0}, {2,0}};
        System.out.println(numberOfBoomerangs(points));
    }
}
