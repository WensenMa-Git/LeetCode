package leetcode.to100;

/**
 * https://leetcode.com/problems/next-permutation/
 * Subject: 找规律
 * #Medium #hard
 */
public class _31_NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                break;
            }
        }
        swap(nums, firstSmall, firstLarge);
        reverse(nums, firstSmall + 1, nums.length - 1);
        return;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i++] = nums[j];
        nums[j--] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    //Provide a second solution (Preferred)
    //https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap2(nums, i, j);
        }
        reverse2(nums, i + 1);
    }

    public void swap2(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse2(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
