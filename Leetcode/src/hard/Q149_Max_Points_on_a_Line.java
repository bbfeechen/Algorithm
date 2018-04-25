package hard;
import java.util.HashMap;
import java.util.Map;


public class Q149_Max_Points_on_a_Line {
	static class Point {
	     int x;
	     int y;
	     Point(int a, int b) { x = a; y = b; }
	}

    public static int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        int max = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int dup = 0, local = 0;
            for (int j = i + 1; j < n; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                int d = gcd(x, y);
                if (d == 0) {
                    dup++;
                } else {
                    String slope = (x / d) + "_" + (y / d);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    local = Math.max(local, map.get(slope));
                }
            }
            max = Math.max(max, local + dup + 1);
        }
        return max;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

	public static void main(String[] args) {
		Point[] points = {
	            new Point(0, 0),
                new Point(94911151, 94911150),
                new Point(94911152, 94911151),
	    };
		System.out.println(maxPoints(points));
	}
}
