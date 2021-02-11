package to500;


public class _453_MinimumMovestoEqualArrayElements {

    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        long sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return (int) (sum - min * nums.length);
    }
}
