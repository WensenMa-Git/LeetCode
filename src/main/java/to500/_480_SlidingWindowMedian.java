package to500;

import java.util.Collections;
import java.util.PriorityQueue;


public class _480_SlidingWindowMedian {


    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.remove());
            } else {
                left.add(nums[i]);
                right.add(left.remove());
            }
            if (left.size() + right.size() == k) {
                double median;
                if (left.size() == right.size()) {
                    median = (double) ((long) left.peek() + (long) right.peek()) / 2;
                } else {
                    median = (double) left.peek();
                }
                int start = i - k + 1;
                res[start] = median;
                if (!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }
            }
        }
        return res;
    }
}
