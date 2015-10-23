package sandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class Solution {
	public static class CPoint {
		double x;
		double y;
		public CPoint(double x, double y) {
			this.x = x;
			this.y = y;
		}
	} 
	
	public static class PointComparator implements Comparator<CPoint> {
		public int compare(CPoint p1, CPoint p2) {
			double dist1 = p1.x * p1.x + p1.y * p1.y;
			double dist2 = p2.x * p2.x + p2.y * p2.y;
			if(dist1 == dist2) {
				return 0;
			}
			return dist1 > dist2 ? 1 : -1;
		}
	}
	
	public static void printKth(List<CPoint> points, int k) {
		PriorityQueue<CPoint> pq = new PriorityQueue<CPoint>(k, new PointComparator());
		for(CPoint point : points) {
			pq.offer(point);
		}
		int count = 0;
		while(!pq.isEmpty()) {
			if(count == k) {
				return;
			}		
			count++;
			CPoint point = pq.poll();
			System.out.println(point.x + " " + point.y);
			
		}
	}

	public static void main(String[] args) {
		CPoint p1 = new CPoint(1.0, 1.0);
		CPoint p2 = new CPoint(7.0, 2.0);
		CPoint p3 = new CPoint(2.0, 1.0);
		CPoint p4 = new CPoint(2.0, 2.0);
		CPoint p5 = new CPoint(3.0, 1.0);
		CPoint p6 = new CPoint(1.0, 3.0);
		List<CPoint> list = new ArrayList<CPoint>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		printKth(list, 3);
	}
}
