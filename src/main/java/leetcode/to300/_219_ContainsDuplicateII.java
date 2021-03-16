package leetcode.to300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 * Subject: Two Pointer, Sliding Window.
 * #Easy
 */
public class _219_ContainsDuplicateII {

    //time : O(n) space : O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if ((i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    //Provide a second solution (Preferred).
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length && i <= k; i++) {
            if (!set.add(nums[i])) return true;
        }
        if (set.size() == nums.length) return false;
        for  (int L = 0, R = k + 1; R < nums.length; R++) {
            set.remove(nums[L++]);
            if (!set.add(nums[R])) return true;
        }
        return false;
    }
}
