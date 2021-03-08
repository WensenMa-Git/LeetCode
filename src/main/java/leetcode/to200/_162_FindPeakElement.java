package leetcode.to200;


public class _162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] > nums[end]) return start;
        return end;
    }

    //Provide a second solution.
    public int findPeakElement2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }
}
