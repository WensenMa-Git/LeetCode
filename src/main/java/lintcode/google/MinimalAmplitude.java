package lintcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=753311&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 * https://www.lintcode.com/problem/minimum-amplitude/
 * https://leetcode.com/discuss/interview-question/553399/
 */
public class MinimalAmplitude {

    public static int minAmplitude1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= k+1) return 0;
        int ans = nums[n-1] - nums[0];
        for(int i = 0, j = n - k - 1; j < nums.length; i++, j++) {
            ans = Math.min(ans, nums[j] - nums[i]);
        }
        return ans;
    }

    private static int minAmplitude2(int[] nums, int k) {
        if(nums.length <= k+1) return 0;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int n : nums) {
            maxQueue.add(n);
            if(maxQueue.size() > k+1) maxQueue.poll();
            minQueue.add(n);
            if(minQueue.size() > k+1) minQueue.poll();
        }
        List<Integer> maxList = new ArrayList<>();
        while(maxQueue.size() > 0) maxList.add(maxQueue.poll());
        List<Integer> minList = new ArrayList<>();
        while(minQueue.size() > 0) minList.add(minQueue.poll());
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= k; i++) {
            ans = Math.min(ans, maxList.get(i) - minList.get(k-i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minAmplitude1(new int[] { -1, 3, -1, 8, 5, 4 }, 3));
        System.out.println(minAmplitude2(new int[] { -1, 3, -1, 8, 5, 4 }, 3));
        System.out.println(minAmplitude1(new int[] { 10, 10, 3, 4, 10 }, 3));
        System.out.println(minAmplitude2(new int[] { 10, 10, 3, 4, 10 }, 3));
        System.out.println(minAmplitude1(new int[] { -2, -1, 0, 1, 2, 3, 4, 5 }, 3));
        System.out.println(minAmplitude2(new int[] { -2, -1, 0, 1, 2, 3, 4, 5 }, 3));
        System.out.println(minAmplitude1(new int[] { 10, 10, 3, 4 }, 3));
        System.out.println(minAmplitude2(new int[] { 10, 10, 3, 4 }, 3));
        System.out.println(minAmplitude1(new int[] { 4, 10 }, 3));
        System.out.println(minAmplitude2(new int[] { 4, 10 }, 3));
    }
}
