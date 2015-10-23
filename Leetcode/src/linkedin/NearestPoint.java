package linkedin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NearestPoint {
	public static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static List<Point> list = new ArrayList<Point>();
	
	public static void addPoint(Point point) {
		list.add(point);
	}
	
	public static List<Point> findNearest(Point center, int p) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>(p, new PointComparator(center));
		for(Point point : list) {
			pq.offer(point);
		}
		List<Point> result = new ArrayList<Point>();
		for(int i = 0; i < p; i++) {
			result.add(pq.poll());
		}
		return result;
	}
	
	private static class PointComparator implements Comparator<Point> {
		private Point target;
		
		public PointComparator(Point target) {
			this.target = target;
		}
		
		public int compare(Point p1, Point p2) {
			return getDistance(p1, target) - getDistance(p2, target);
		}
		
		private int getDistance(Point p1, Point p2) {
			return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
		}
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(5, 4);
		Point p3 = new Point(3, 3);
		Point p4 = new Point(2, 2);
		Point p5 = new Point(3, 2);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		List<Point> res = findNearest(new Point(2, 2), 3);
		for(Point p : res) {
			System.out.println(p.x + " " + p.y);
		}
	}
	
//	//------------------
//	public static int quickselect(int[] G, int k) {
//		return quickselect(G, 0, G.length - 1, k - 1);
//	}
//	 
//	private static int quickselect(int[] G, int first, int last, int k) {
//		if (first <= last) {
//			int pivot = partition(G, first, last);
//			if (pivot == k) {
//				return G[k];
//			}
//			if (pivot > k) {
//				return quickselect(G, first, pivot - 1, k);
//			}
//			return quickselect(G, pivot + 1, last, k);
//		}
//		return Integer.MIN_VALUE;
//	}
//	 
//	private static int partition(int[] G, int first, int last) {
//		int pivot = first + new Random().nextInt(last - first + 1);
//		swap(G, last, pivot);
//		for (int i = first; i < last; i++) {
//			if (G[i] > G[last]) {
//				swap(G, i, first);
//				first++;
//			}
//		}
//		swap(G, first, last);
//		return first;
//	}
//	 
//	private static void swap(int[] G, int x, int y) {
//		int tmp = G[x];
//		G[x] = G[y];
//		G[y] = tmp;
//	}
//
//	public static void main(String[] args) {
//		int[] G = {6, 8, 9, 4, 3, 1, 2};
//		System.out.println(quickselect(G, 3));
//	}
}
