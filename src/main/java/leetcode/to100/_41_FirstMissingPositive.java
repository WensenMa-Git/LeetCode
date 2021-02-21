package leetcode.to100;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * #Hard
 */
public class _41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    //Provide a second solution. (O(nlogn))
    public int firstMissingPositive2(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        while(index < nums.length && nums[index] < 1) index++;
        int pre = 0;
        while(index < nums.length){
            if(nums[index] > pre + 1){
                return pre + 1;
            }
            pre = nums[index++];
        }
        return pre + 1;
    }

    //Provide a third solution (Preferred)
    public int firstMissingPositive3(int[] nums) {
        int min = 1;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num > min) break;
            if (num == min) min++;
        }
        return min;
    }
}
