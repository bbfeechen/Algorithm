package secret;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q253_Meeting_Rooms_II {
	public static class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	}
	
	public static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
         
        Arrays.sort(intervals, new IntervalComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numRooms = 1;
         
        pq.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < pq.peek()) {
                numRooms++;
                pq.offer(intervals[i].end);
            } else {
                pq.poll();
                pq.offer(intervals[i].end);
            }
        }
         
        return numRooms;
         
    }
     
    public static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
