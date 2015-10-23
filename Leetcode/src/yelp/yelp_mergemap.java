package yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class yelp_mergemap {
	public static class Interval {
		int start;
		int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static String mergeMap(String[] strs) {
		Map<String, List<Interval>> map = new HashMap<String, List<Interval>>();
		for(String str : strs) {
			String[] parts = str.trim().split(":");
			String date = parts[0].trim();
			String[] ranges = parts[1].trim().split(",");
			if(!map.containsKey(date)) {
				map.put(date, new ArrayList<Interval>());
			}
			for(String range : ranges) {
				String[] startend = range.split("-");
				Interval interval = new Interval(Integer.valueOf(startend[0].trim()), 
						Integer.valueOf(startend[1].trim()));
				List<Interval> list = map.get(date);
				if(!list.contains(interval)) {
					list.add(interval);
				}
			}
		}
		Iterator itor = map.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		while(itor.hasNext()) {
			Map.Entry entry = (Map.Entry)itor.next();
			String date = (String)entry.getKey();
			List<Interval> ranges = (List<Interval>)entry.getValue();
			List<Interval> mergedRanges = mergeInterval(ranges);
			map.put(date, mergedRanges);
			sb.append(date);
			sb.append(" : ");
			for(Interval interval : mergedRanges) {
				sb.append(interval.start);
				sb.append(" - ");
				sb.append(interval.end);
				sb.append("  ");
			}
			sb.append("	");
		}
		return sb.toString();
	}
	
	private static List<Interval> mergeInterval(List<Interval> ranges) {
		List<Interval> list = new ArrayList<Interval>();
		Collections.sort(ranges, new IntervalComparator());
		Interval prev = ranges.get(0);
		for(int i = 1; i < ranges.size(); i++) {
			Interval curr = ranges.get(i);
			if(prev.end < curr.start) {
				list.add(prev);
				prev = curr;
			} else {
				prev.end = Math.max(prev.end, curr.end);
			}
		}
		list.add(prev);
		return list;
	}
	
	private static class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}

	public static void main(String[] args) {
		String[] strs = {"Monday : 200 - 300, 500 - 700, 300 - 500", "Tuesday : 300 - 500, 700 - 900"};
		System.out.println(mergeMap(strs));
	}
}
