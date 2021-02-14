package leetcode.to100;

import leetcode.dependency.Interval;

import java.util.ArrayList;
import java.util.List;


public class _57_InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) return intervals;
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i++).end);
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }

    //Provide a second implementation
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval == null) return intervals;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i++][1], newInterval[1]);
        }
        res.add(newInterval);
        while(i < intervals.length) {
            res.add(intervals[i++]);
        }
        int[][] result = new int[res.size()][2];
        for(int j = 0; j < result.length; j++){
            result[j] = res.get(j);
        }
        return result;
    }
}
