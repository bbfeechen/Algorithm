package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q616_Add_Bold_Tag_in_String {
    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static String addBoldTag(String s, String[] dict) {
        if (s == null || s.isEmpty() || dict.length == 0) {
            return s;
        }
        List<Interval> intervals = new ArrayList<>();
        for (String word : dict) {
            int index = 0;
            while (index < s.length()) {
                if (!s.substring(index).contains(word)) {
                    break;
                }
                int start = index + s.substring(index).indexOf(word);
                int end = start + word.length() - 1;
                intervals.add(new Interval(start, end));
                index = start + 1;
            }
        }
        if (intervals.isEmpty()) {
            return s;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        List<Interval> merged = new ArrayList<>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (prev.end < curr.start - 1) {
                merged.add(prev);
                prev = curr;
            } else if (prev.end < curr.end) {
                prev.end = curr.end;
            }
        }
        merged.add(prev);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Interval interval : merged) {
            int start = interval.start;
            int end = interval.end;
            if (i >= s.length()) {
                break;
            }
            sb.append(s.substring(i, start));
            sb.append("<b>");
            sb.append(s.substring(start, end + 1));
            sb.append("</b>");
            i = end + 1;
        }
        if (i < s.length()) {
            sb.append(s.substring(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBoldTag("aaabbcc", new String[] {"aaa","aab","bc","aaabbcc"}));
    }
}
