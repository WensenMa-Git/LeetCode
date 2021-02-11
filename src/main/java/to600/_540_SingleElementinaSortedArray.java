package to600;


public class _540_SingleElementinaSortedArray {


    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length / 2;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[2 * mid] != nums[2 * mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[2 * start];
    }
}
