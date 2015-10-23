package yelp;

public class yelp_issquare {
	public static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean isSquare(Point[] p) {
		for(int i = 0; i < 4; i++) {
			for(int j = i + 1; j < 4; j++) {
				if(p[i].x == p[j].x && p[i].y == p[j].y) {
					return false;
				}
			}
		}
		
		if(dist(p[0], p[1]) == dist(p[2], p[3]) && mid(p[0], p[1], p[2], p[3]) 
				&& dist(p[0], p[2]) == dist(p[0], p[3])) {
			return true;
		}
		if(dist(p[0], p[2]) == dist(p[1], p[3]) && mid(p[0], p[2], p[1], p[3]) 
				&& dist(p[0], p[1]) == dist(p[0], p[3])) {
			return true;
		}
		if(dist(p[0], p[3]) == dist(p[1], p[2]) && mid(p[0], p[3], p[1], p[2]) 
				&& dist(p[0], p[1]) == dist(p[0], p[2])) {
			return true;
		}
		return false;
	}
	
	private static int dist(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}
	
	private static boolean mid(Point a, Point b, Point c, Point d) {
		return ((a.x + b.x) == (c.x + d.x) && (a.y + b.y) == (c.y + d.y));
	} 

	public static void main(String[] args) {
		Point[] points = new Point[4];
		points[0] = new Point(1, 1);
		points[1] = new Point(1, 3);
		points[2] = new Point(5, 1);
		points[3] = new Point(5, 3);
		System.out.println(isSquare(points));
	}

}
