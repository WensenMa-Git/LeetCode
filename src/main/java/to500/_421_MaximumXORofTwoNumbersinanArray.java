package to500;

import java.util.HashSet;


public class _421_MaximumXORofTwoNumbersinanArray {


    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = res | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }
}
