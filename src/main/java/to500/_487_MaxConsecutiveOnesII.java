package to500;

import java.util.LinkedList;
import java.util.Queue;


public class _487_MaxConsecutiveOnesII {


    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int k = 1;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0, l = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queue.offer(i);
            }
            if (queue.size() > k) {
                l = queue.poll() + 1;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int res = 0;
        int queue = -1;

        for (int i = 0, l = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                l = queue + 1;
                queue = i;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}
