package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q218_The_Skyline_Problem {
    public List<int[]> getSkyline2(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new int[] { building[0], -building[2] });
            points.add(new int[] { building[0],  building[1] });
        }
        Collections.sort(points, new Comparator<int[]>(){
        @Override
        public int compare(int[] p1, int[] p2) {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            } else {
                return p1[0] - p2[0];
            }
        }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer h1, Integer h2) {
            return h2 - h1;
        }
        });
        pq.offer(0);
        List<int[]> result = new ArrayList<>();
        int prev = 0;
        for (int[] point : points) {
            if (point[1] < 0) {
                pq.offer(-point[1]);
            } else {
                pq.remove(point[1]);
            }
            int curr = pq.peek();
            if (prev != curr) {
                result.add(new int[] { point[0], curr });
                prev = curr;
            }
        }
        return result;
    }

//	public class Edge {
//        int x;
//        int height;
//        boolean isStart;
//        public Edge(int x, int height, boolean isStart) {
//            this.x = x;
//            this.height = height;
//            this.isStart = isStart;
//        }
//    }
//
//    public List<int[]> getSkyline1(int[][] buildings) {
//        List<int[]> result = new ArrayList<int[]>();
//        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
//            return result;
//        }
//
//        List<Edge> edges = new ArrayList<Edge>();
//        for(int[] building : buildings) {
//            Edge start = new Edge(building[0], building[2], true);
//            edges.add(start);
//            Edge end = new Edge(building[1], building[2], false);
//            edges.add(end);
//        }
//
//        Collections.sort(edges, new Comparator<Edge>() {
//            public int compare(Edge e1, Edge e2) {
//                if(e1.x != e2.x) {
//                    return Integer.compare(e1.x, e2.x);
//                }
//                if(e1.isStart && e2.isStart) {
//                    return Integer.compare(e2.height, e1.height);
//                }
//                if(!e1.isStart && !e2.isStart) {
//                    return Integer.compare(e1.height, e2.height);
//                }
//                return e1.isStart ? -1 : 1;
//            }
//        });
//
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
//        for(Edge edge : edges) {
//            if(edge.isStart) {
//                if(pq.isEmpty() || edge.height > pq.peek()) {
//                    result.add(new int[]{ edge.x, edge.height });
//                }
//                pq.add(edge.height);
//            } else {
//                pq.remove(edge.height);
//                if(pq.isEmpty()) {
//                    result.add(new int[] { edge.x, 0 });
//                } else if(edge.height > pq.peek()) {
//                    result.add(new int[] { edge.x, pq.peek() });
//                }
//            }
//        }
//
//        return result;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
