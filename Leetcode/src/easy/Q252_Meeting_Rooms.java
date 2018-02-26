package easy;

import java.util.Arrays;
import java.util.Comparator;


//	Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
//	
//	For example,
//	
//	Given [[0, 30],[5, 10],[15, 20]],
//	return false.

public class Q252_Meeting_Rooms {
	static class Interval {
		int start;
		int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}
	
//	public static boolean canAttendMeetings(Interval[] intervals) {
//		if(intervals == null || intervals.length == 0) {
//			return true;
//		}
//		Arrays.sort(intervals, new IntervalComparator());
//		Interval prev = intervals[0];
//		for(int i = 1; i < intervals.length; i++) {
//			Interval curr = intervals[i];
//			if(isOverlapped(prev, curr)) {
//				return false;
//			}
//			prev = curr;
//		}
//		return true;
//	}

	public static boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i + 1].start < intervals[i].end) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isOverlapped(Interval i1, Interval i2) {
		return i2.start < i1.end;
	}
	
	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		
		System.out.println(canAttendMeetings(intervals));
	}

}
