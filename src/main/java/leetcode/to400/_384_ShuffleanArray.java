package leetcode.to400;

import java.util.Random;


public class _384_ShuffleanArray {


    private final int[] nums;
    private final Random rmd;

    // 题中第构造函数时Solution
    public _384_ShuffleanArray(int[] nums) {
        this.nums = nums;
        rmd = new Random();
    }


    public int[] reset() {
        return nums;
    }


    public int[] shuffle() {
        if (nums == null) return null;
        int[] clone = nums.clone();
        for (int i = 1; i < clone.length; i++) {
            int random = rmd.nextInt(i + 1);
            swap(clone, i, random);
        }
        return clone;
    }

    private void swap(int[] clone, int i, int j) {
        int temp = clone[i];
        clone[i] = clone[j];
        clone[j] = temp;
    }
}
