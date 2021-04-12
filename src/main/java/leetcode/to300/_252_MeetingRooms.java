package leetcode.to300;

import leetcode.dependency.Interval;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms/
 * Subject: Array
 * #Easy
 */
public class _252_MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }
}
