package to600;

import java.util.Arrays;
import java.util.Stack;


public class _503_NextGreaterElementII {


    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len * 2; i++) {
            int num = nums[i % len];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < len) {
                stack.push(i);
            }
        }

        return res;
    }
}
