package supplement;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static class MyCalendar3 {

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
            //right is the index where event start time just smaller than the target end
            if (right == -1 || events.get(right)[1] <= start) {
                events.add(right + 1, new int[]{start, end});
                return true;
            } else {
                return false;
            }

        }
    }

    public static void main(String[] args) {
        MyCalendar3 myCalendar3 = new MyCalendar3();
        System.out.println(myCalendar3.book(1, 3));
        System.out.println(myCalendar3.book(6, 8));
        System.out.println(myCalendar3.book(4, 7));
    }


}
