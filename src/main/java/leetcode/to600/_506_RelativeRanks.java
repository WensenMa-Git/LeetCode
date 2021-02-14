package leetcode.to600;


public class _506_RelativeRanks {


    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]] = i + 1;
        }
        int medal = 1;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != 0) {
                if (medal == 1) {
                    res[bucket[i] - 1] = "Gold Medal";
                } else if (medal == 2) {
                    res[bucket[i] - 1] = "Silver Medal";
                } else if (medal == 3) {
                    res[bucket[i] - 1] = "Bronze Medal";
                } else {
                    res[bucket[i] - 1] = String.valueOf(medal);
                }
                medal++;
            }
        }
        return res;
    }
}
