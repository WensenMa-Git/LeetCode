package leetcode.to500;

import java.util.HashSet;
import java.util.PriorityQueue;


public class _414_ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }


    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                priorityQueue.offer(num);
                if (priorityQueue.size() > 3) priorityQueue.poll();
            }
        }
        if (priorityQueue.size() == 2) priorityQueue.poll();
        return priorityQueue.peek();
    }

}
