package to500;

import dependency.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class _435_NonoverlappingIntervals {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a.end - b.end);
        int end = intervals[0].end;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    public int eraseOverlapIntervals2(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) return o1.end - o2.end;
                return o2.start - o1.start;
            }
        });
        int end = Integer.MIN_VALUE;
        int res = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end) {
                end = interval.end;
            } else {
                res++;
            }
        }
        return res;
    }
}
