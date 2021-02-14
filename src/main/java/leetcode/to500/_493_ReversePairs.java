package leetcode.to500;


public class _493_ReversePairs {


    public static int reversePairs(int[] nums) {
        return mergeSortHelper(nums, 0, nums.length - 1);
    }

    private static int mergeSortHelper(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + ((right - left) / 2);
        int res = mergeSortHelper(nums, left, mid) + mergeSortHelper(nums, mid + 1, right);

        int i = left, j = mid + 1, k = 0, p = mid + 1;
        int[] merge = new int[right - left + 1];

        while (i <= mid) {
            while (p <= right && nums[i] > 2L * nums[p]) {
                p++;
            }
            res += p - (mid + 1);

            while (j <= right && nums[i] >= nums[j]) {
                merge[k++] = nums[j++];
            }
            merge[k++] = nums[i++];
        }
        while (j <= right) {
            merge[k++] = nums[j++];
        }

        System.arraycopy(merge, 0, nums, left, merge.length);
        return res;
    }

    public static void main(String[] args) {
        reversePairs(new int[]{1, 3, 2, 3, 1});
    }
}
