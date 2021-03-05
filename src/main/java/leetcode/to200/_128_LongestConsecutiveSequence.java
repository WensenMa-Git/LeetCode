package leetcode.to200;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Subject: Array
 * #Hard
 */
public class _128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            res = Math.max(res, up - down - 1);
        }
        return res;
    }

    //Provide a second solution (Preferred).
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }

        for (int L = 0, R = 1; R <= index; R++) {
            if (R == index || nums[R] != nums[R - 1] + 1) {
                if (R - L > res) {
                    res = R - L;
                }
                L = R;
            }
        }
        return res;
    }
}
