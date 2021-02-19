package leetcode.to100;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/
 * Subject: Array
 * #Easy
 */
public class _27_RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return res;
    }

    //Provide a second solution (Preferred)
    public int removeElement2(int[] nums, int val) {
        int index = 0;
        for(int n : nums){
            if(n != val){
                nums[index++] = n;
            }
        }
        return index;
    }
}
