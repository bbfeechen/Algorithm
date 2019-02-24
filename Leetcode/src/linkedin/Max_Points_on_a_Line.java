package linkedin;
import java.util.HashMap;
import java.util.Map;


public class Max_Points_on_a_Line {
	static class Point {
	     int x;
	     int y;
	     Point() { x = 0; y = 0; }
	     Point(int a, int b) { x = a; y = b; }
	}

    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int dup = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                }
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                int gcd = gcd(dx, dy);
                if (gcd != 0) {
                    dx = dx / gcd;
                    dy = dy / gcd;
                }
                String key = dx + "_" + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            res = Math.max(res, dup);
            for(int val : map.values()) {
                res = Math.max(res, val + dup);
            }
        }
        return res;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
	 
//    public int maxPoints(Point[] points) {
//        if(points == null || points.length == 0) {
//            return 0;
//        }
//        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
//        int max = 1;
//        for(int i = 0; i < points.length; i++) {
//            map.clear();
//            map.put((double)Integer.MIN_VALUE, 1);
//
//            int dup = 0;
//            for(int j = i + 1; j < points.length; j++) {
//                if(points[j].x == points[i].x && points[j].y == points[i].y) {
//                    dup++;
//                    continue;
//                }
//                double key = (points[i].x - points[j].x == 0) ? Integer.MAX_VALUE :
//                    0.0 + ((double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x));
//                if(map.containsKey(key)) {
//                    map.put(key, map.get(key) + 1);
//                } else {
//                    map.put(key, 2);
//                }
//            }
//            for(int temp : map.values()) {
//                if(temp + dup > max) {
//                    max = temp + dup;
//                }
//            }
//        }
//        return max;
//    }

	public static void main(String[] args) {
	    Point[] points = {new Point(1, 1), new Point(2, 2), new Point(3, 3)};
        System.out.println(maxPoints(points));
	}
}
