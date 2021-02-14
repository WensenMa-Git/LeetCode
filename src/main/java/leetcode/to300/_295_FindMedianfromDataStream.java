package leetcode.to300;

import java.util.PriorityQueue;


public class _295_FindMedianfromDataStream {


    private final PriorityQueue<Long> small;
    private final PriorityQueue<Long> large;

    public _295_FindMedianfromDataStream() {  // MedianFinder()
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2;
    }
}
