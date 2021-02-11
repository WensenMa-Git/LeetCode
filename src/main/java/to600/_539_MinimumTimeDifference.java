package to600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class _539_MinimumTimeDifference {


    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int hour = Integer.parseInt(t[0]);
            int minute = Integer.parseInt(t[1]);
            if (mark[hour * 60 + minute]) {
                return 0;
            }
            mark[hour * 60 + minute] = true;
        }
        int res = Integer.MAX_VALUE;
        int pre = -1;
        int first = -1;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    Math.min(res, i - pre);
                }
                pre = i;
            }
        }
        res = Math.min(res, (first + 24 * 60 - pre));
        return res;
    }

    public int findMinDifference2(List<String> timePoints) {
        List<Time> times = new ArrayList<>();
        for (String time : timePoints) {
            String[] strs = time.split(":");
            times.add(new Time(Integer.parseInt(strs[0]), Integer.parseInt(strs[1])));
        }
        Collections.sort(times);
        Time first = times.get(0);
        times.add(new Time(first.hour + 24, first.minute));
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            int diff = Math.abs(times.get(i).getDiff(times.get(i + 1)));
            res = Math.min(res, diff);
        }
        return res;
    }

    class Time implements Comparable<Time> {
        int hour;
        int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public int compareTo(Time other) {
            if (this.hour == other.hour) {
                return this.minute - other.minute;
            }
            return this.hour - other.hour;
        }

        public int getDiff(Time other) {
            return (this.hour - other.hour) * 60 + (this.minute - other.minute);
        }
    }
}
