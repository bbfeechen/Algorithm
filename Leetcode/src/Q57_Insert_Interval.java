import java.util.ArrayList;
import java.util.List;


public class Q57_Insert_Interval {
	public static class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	}	
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if(newInterval == null || intervals == null) {
            return null;
        }
        
        int insertPos = 0;
        for(Interval interval : intervals) {
            if(interval.end < newInterval.start) {
                result.add(interval);
                insertPos++;
            } else if(interval.start > newInterval.end) {
                result.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        
        result.add(insertPos, newInterval);
        return result;
    }
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		
		Interval newInterval = new Interval(4,9);
		List<Interval> result = insert(intervals, newInterval);
		for(Interval interval : result) {
			System.out.print(" [" + interval.start + ", " + interval.end + "] ");
		}
	}

}
