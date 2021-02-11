package to600;

import java.util.Arrays;


public class _561_ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public int arrayPairSum2(int[] nums) {
        int[] bucket = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] + 10000]++;
        }
        int res = 0;
        boolean odd = true;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                if (odd) {
                    res += i - 10000;
                }
                odd = !odd;
                bucket[i]--;
            }
        }
        return res;
    }
}
