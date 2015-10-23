package linkedin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Merge_Intervals {
	public static class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	}	
	
	public static List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, new IntervalComparator());
        Interval prev = intervals.get(0);
        List<Interval> result = new ArrayList<Interval>();
        
        for(int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if(curr.start <= prev.end) {
                prev.end = Math.max(curr.end, prev.end);
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        
        result.add(prev);
        return result;
    }
    
    public static class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
