package leetcode.to600;


public class _581_ShortestUnsortedContinuousSubarray {


    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start = -1;
        int end = -1;
        int min = nums[len - 1], max = nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - 1 - i]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[len - 1 - i] > min) {
                start = len - 1 - i;
            }
        }
        return end - start + 1;
    }
}
