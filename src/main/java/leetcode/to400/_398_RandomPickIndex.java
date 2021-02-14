package leetcode.to400;

import java.util.Random;


public class _398_RandomPickIndex {


    private final int[] nums;
    Random rmd;

    public _398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        rmd = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (rmd.nextInt(++count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
