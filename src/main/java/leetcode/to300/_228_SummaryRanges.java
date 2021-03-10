package leetcode.to300;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 * Subject: Array
 * #Easy
 * Similar Questions: 163. Missing Ranges
 */
public class _228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num != nums[i]) {
                res.add(num + "->" + nums[i]);
            } else {
                res.add(num + "");
            }
        }
        return res;
    }

    //Provide a second solution (Preferred)
    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int L= 0, R = 1; R <= nums.length; R++) {
            if (R == nums.length || nums[R] != nums[R - 1] + 1) {
                res.add (print(nums[L], nums[R - 1]));
                L = R;
            }
        }
        return res;
    }

    private String print(int leftValue, int rightValue) {
        if (leftValue == rightValue) {
            return String.valueOf(leftValue);
        } else {
            return leftValue + "->" + rightValue;
        }
    }
}
