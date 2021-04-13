package leetcode.to300;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * Subject: Sliding Window, Array
 * #Hard
 */
public class _239_SlidingWindowMaximum {

    //Provide a second soluiton.
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if ((i + 1) >= k) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        return res;
    }

    //Provide a second solution (Time Limit Exceeded)
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] res = new int[nums.length + 1 - k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                res[index++] = pq.peek();
                pq.remove(nums[i - k]);
                pq.offer(nums[i]);
            }
        }
        res[index] = pq.peek();
        return res;
    }

    //Provide a second solution.
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (null == nums || nums.length == 0) return nums;
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int j = 0; j < k; j++) {
            if (nums[j] >= max) {
                max = nums[j];
                maxIndex = j;
            }
        }
        res[0] = max;
        for (int i = 1; i <= nums.length - k; i++) {
            if (maxIndex == i - 1) {
                max = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            } else if (nums[i + k - 1] > max) {
                max = nums[i + k - 1];
                maxIndex = i + k - 1;
            }
            res[i] = max;
        }
        return res;
    }
}
