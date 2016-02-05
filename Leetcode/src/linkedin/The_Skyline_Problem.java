package linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class The_Skyline_Problem {
	public static class Edge {
        int x;
        int height;
        boolean isStart;
        public Edge(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }
    
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }
        
        List<Edge> edges = new ArrayList<Edge>();
        for(int[] building : buildings) {
            Edge start = new Edge(building[0], building[2], true);
            edges.add(start);
            Edge end = new Edge(building[1], building[2], false);
            edges.add(end);
        }
        
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                if(e1.x != e2.x) {
                    return Integer.compare(e1.x, e2.x);
                }
                if(e1.isStart && e2.isStart) {
                    return Integer.compare(e2.height, e1.height);
                }
                if(!e1.isStart && !e2.isStart) {
                    return Integer.compare(e1.height, e2.height);
                }
                return e1.isStart ? -1 : 1;
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        for(Edge edge : edges) {
            if(edge.isStart) {
                if(pq.isEmpty() || edge.height > pq.peek()) {
                    result.add(new int[]{ edge.x, edge.height });
                }
                pq.add(edge.height);
            } else {
                pq.remove(edge.height);
                if(pq.isEmpty()) {
                    result.add(new int[] { edge.x, 0 });
                } else if(edge.height > pq.peek()) {
                    result.add(new int[] { edge.x, pq.peek() });
                }
            }
        }
        
        return result;
    }

	public static void main(String[] args) {
		int[][] buildings = {
				  {1, 3, 3},
				  {2, 4, 4},
				  {5, 6, 1}
		};
		List<int[]> result = getSkyline(buildings);
		for(int[] keypoints : result) {
			for(int point : keypoints) {
				System.out.print(point + " ");
			}
			System.out.println();
		}
	}
}
