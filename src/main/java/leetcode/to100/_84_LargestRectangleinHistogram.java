package leetcode.to100;

import java.util.Stack;


public class _84_LargestRectangleinHistogram {

    //Preferred Solution.
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i - start - 1);
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }

    //Provide a second solution
    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i <= heights.length; i++) {
            if (stack.isEmpty() || (i != heights.length && heights[i] > heights[stack.peek()])) {
                stack.push(i);
            }
            else {
                int temp = stack.pop();
                sum = Math.max(sum, heights[temp] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }
        return sum;
    }
}
