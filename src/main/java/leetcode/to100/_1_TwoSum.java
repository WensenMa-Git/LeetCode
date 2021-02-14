package leetcode.to100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * Subject: Array, Map. (or Two Pointer)
 * #Easy
 */
public class _1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        int[] res = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    //Provide a second solution (Preferred)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int pair = target - nums[i];
            if(map.containsKey(pair)){
                return new int[]{map.get(pair), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
