package to400;

import java.util.Map;
import java.util.TreeMap;


public class _327_CountofRangeSum {


    // time : O(n^2) 不确定 space : O(n)
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        treeMap.put((long) 0, (long) 1);
        long sum = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long from = sum - upper;
            long to = sum - lower;
            Map<Long, Long> sub = treeMap.subMap(from, true, to, true);
            for (Long value : sub.values()) {
                count += value;
            }
            treeMap.put(sum, treeMap.getOrDefault(sum, (long) 0) + 1);
        }
        return (int) count;
    }

    // time : O(nlogn) space : O(n)
    public int countRangeSum2(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        return helper(sum, new long[sum.length], 0, sum.length - 1, lower, upper);
    }


    private int helper(long[] sum, long[] helper, int low, int high, long lower, long upper) {
        if (low >= high) {
            return 0;
        }

        int mid = (high + 1 - low) / 2 + low;
        int count = helper(sum, helper, low, mid - 1, lower, upper)
                + helper(sum, helper, mid, high, lower, upper);

        int rangeStart = mid, rangeEnd = mid;
        for (int i = low; i < mid; i++) {
            while (rangeStart <= high && sum[rangeStart] - sum[i] < lower)
                rangeStart++;
            while (rangeEnd <= high && sum[rangeEnd] - sum[i] <= upper)
                rangeEnd++;

            count += rangeEnd - rangeStart;
        }

        merge(sum, helper, low, mid, high);
        return count;
    }

    private void merge(long[] sum, long[] helper, int low, int mid, int high) {
        int left = low, right = mid, idx = low;

        while (left < mid && right <= high) {
            if (sum[left] <= sum[right])
                helper[idx++] = sum[left++];
            else
                helper[idx++] = sum[right++];
        }

        while (left < mid)
            helper[idx++] = sum[left++];
        while (right <= high)
            helper[idx++] = sum[right++];

        System.arraycopy(helper, low, sum, low, high + 1 - low);
    }
}
