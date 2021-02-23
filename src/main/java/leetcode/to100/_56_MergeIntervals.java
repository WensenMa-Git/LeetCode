package leetcode.to100;

import leetcode.dependency.Interval;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 * Subject: Interval
 * #Medium
 */
public class _56_MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    //Provide a second solution (Preferred)
    public List<Interval> merge2(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return intervals;
//        Collections.sort(intervals, (l1, l2) -> l1.start - l2.start);
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval l1, Interval l2) {
                return l1.start - l2.start;
            }
        });
        Iterator<Interval> it = intervals.iterator();
        Interval pre = it.next();
        while (it.hasNext()) {
            Interval cur = it.next();
            if (pre.end < cur.start) {
                pre = cur;
            } else {
                pre.end = Math.max(pre.end, cur.end);
                it.remove();
            }
        }
        return intervals;
    }

}
