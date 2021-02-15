package leetcode.to100;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * Subject: Two Pointer
 * #Medium
 */
public class _11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else r--;
        }
        return res;
    }
}
