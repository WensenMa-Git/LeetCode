package to600;

import java.util.HashMap;
import java.util.Map;


public class _532_KdiffPairsinanArray {


    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    res++;
                }
            }
        }
        return res;
    }
}
