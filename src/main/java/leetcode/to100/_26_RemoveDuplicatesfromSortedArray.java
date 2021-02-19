package leetcode.to100;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Subject: Array
 * #Easy
 */
public class _26_RemoveDuplicatesfromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
