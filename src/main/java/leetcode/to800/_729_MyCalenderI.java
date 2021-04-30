package leetcode.to800;

import java.util.*;

public class _729_MyCalenderI {

    //Solution 1
    class MyCalendar {
        class Event{
            int start;
            int end;
            public Event(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        List<Event> events;
        public MyCalendar() {
            events = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            end--;
            int low = 0;
            int high = events.size() - 1;
            while(low <= high){
                int mid = low + (high - low) /2;
                Event tmp = events.get(mid);
                if(start == tmp.end) return false;
                if(start < tmp.end){
                    if(end >= tmp.start) return false;
                }
                if(tmp.end < start){
                    low = mid + 1;
                } else{
                    high = mid - 1;
                }
            }
            events.add(low, new Event(start, end));
            return true;
        }
    }

    class MyCalendar2 {
        TreeMap<Integer, Integer> map;

        public MyCalendar2() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> prev = map.lowerEntry(end);
            if (prev == null || prev.getValue() <= start) {
                map.put(start, end);
                return true;
            }
            return false;
        }
    }

    //Preferred solution.
    class MyCalendar3 {

        List<int[]> events;
        public MyCalendar3() {
            events = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int left = 0, right = events.size() - 1;
            while(left <= right) {
                int middle = (left + right) / 2;
                if (events.get(middle)[0] >= end) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            //right is the index where event start time just smaller than start
            if (right == -1 || events.get(right)[1] <= start) {
                events.add(right + 1, new int[]{start, end});
                return true;
            } else {
                return false;
            }

        }
    }

}
