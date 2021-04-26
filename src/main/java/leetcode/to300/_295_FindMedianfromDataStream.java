package leetcode.to300;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * Subject: PriorityQueue
 * #Hard
 */
public class _295_FindMedianfromDataStream {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    /** initialize your data structure here. */
    public _295_FindMedianfromDataStream() {  // MedianFinder()
        pq2 = new PriorityQueue<>();//ascending
        pq1 = new PriorityQueue<>((x, y)->y - x);//dscending
    }

    public void addNum(int num) {
        pq2.add(num);
        pq1.add(pq2.poll());
        if (pq1.size() - pq2.size()>1) {
            pq2.add(pq1.poll());
        }
    }

    public double findMedian() {
        if (pq1.size() == pq2.size()) {
            return (double)(pq1.peek() + pq2.peek()) / 2;
        }
        else {
            return pq1.peek();
        }
    }

    //Provide a second solution.
    class MedianFinder2 {
        PriorityQueue<Integer> low;  // max heap
        PriorityQueue<Integer> high; // min heap

        /** initialize your data structure here. */
        public MedianFinder2() {
            low = new PriorityQueue<>(Collections.reverseOrder());
            high = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (low.isEmpty() || num < low.peek()) {
                low.offer(num);
            } else {
                high.offer(num);
            }

            if (Math.abs(low.size() - high.size()) > 1) {
                if (low.size() > high.size()) {
                    high.offer(low.poll());
                } else {
                    low.offer(high.poll());
                }
            }
        }

        public double findMedian() {
            if (low.size() == high.size()) {
                return ((double)low.peek() + (double)high.peek()) / 2.0;
            } else if (low.size() > high.size()) {
                return low.peek();
            } else
                return high.peek();
        }
    }
}
