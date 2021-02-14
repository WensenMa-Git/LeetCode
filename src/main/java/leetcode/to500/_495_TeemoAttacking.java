package leetcode.to500;


public class _495_TeemoAttacking {


    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            sum += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return sum + duration;
    }
}
