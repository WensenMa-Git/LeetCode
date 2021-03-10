package leetcode.to200;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/missing-ranges/
 * Subject: Array
 * #Easy
 * Similar questions: 228. Summary Ranges
 */
public class _163_MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long alower = lower, aupper = upper;
        for (int num : nums) {
            if (num == alower) {
                alower++;
            } else if (alower < num) {
                if (alower + 1 == num) {
                    res.add(String.valueOf(alower));
                } else {
                    res.add(alower + "->" + (num - 1));
                }
                alower = (long) num + 1;
            }
        }
        if (alower == aupper) res.add(String.valueOf(alower));
        else if (alower < aupper) res.add(alower + "->" + aupper);
        return res;
    }

    //Provide a second solution (Preferred).
    public List<String> findMissingRanges2(int[] nums, int lower, int upper) {
        long small = lower, large = upper;
        List<String> res = new ArrayList<>();
        long pre = small - 1;
        for(int i = 0; i <= nums.length; i++){
            long cur = i == nums.length ? large + 1 : nums[i];
            if(cur > pre + 1){
                res.add(generate(pre + 1, cur - 1));
            }
            pre = cur;
        }
        return res;
    }

    private String generate(long leftValue, long rightValue){
        if(leftValue == rightValue){
            return String.valueOf(leftValue);
        }else{
            return leftValue + "->" + rightValue;
        }
    }
}
