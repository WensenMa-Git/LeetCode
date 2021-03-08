package leetcode.to200;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Subject: Binary Search
 * #Medium
 */
public class _153_FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }

    //Provide a second solution (Preferred).
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right && nums[left] > nums[right]) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }
}
