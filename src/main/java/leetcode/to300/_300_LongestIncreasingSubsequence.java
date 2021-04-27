package leetcode.to300;

import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i != j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == res) ++res;
        }
        return res;
    }

    //Provide a second solution. (Preferred)
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

    //Provide a third solution. (Preferred)
    public int lengthOfLIS3(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = 0;
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int index = binarySearch(temp, length, nums[i]);
            temp[index] = nums[i];
            if(index == length){
                length++;
            }
        }
        return length;
    }

    private int binarySearch(int[] array, int right, int target){
        int low = 0, high = right - 1;
        while(low <= high){
            int middle = (low + high) >>> 1;
            if(array[middle] < target){
                low = middle + 1;
            }else if(array[middle] > target){
                high = middle - 1;
            }else{
                return middle;
            }
        }
        return low;
    }
}
