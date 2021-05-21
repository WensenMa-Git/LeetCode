package leetcode.to300;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Subject: Array
 * #Medium
 */
public class _238_ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    //Provide a second solution. (Preferred).
    public int[] productExceptSelf2(int[] nums) {
        int result = 1;
        int countOfZero = 0;
        int[] numbers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countOfZero++;
                continue;
            }
            result *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (countOfZero == 0) {
                numbers[i] = result / nums[i];
            } else if (countOfZero == 1 && nums[i] == 0) {
                numbers[i] = result;
            } else {
                numbers[i] = 0;
            }
        }
        return numbers;
    }

    public int[] productExceptSelf3(int[] nums) {
        int length = nums.length;
        int[] numbers1 = new int[length];
        int[] numbers2 = new int[length];
        int[] result = new int[length];
        numbers1[0] = nums[0];
        for (int i = 1; i < length; i++) {
            numbers1[i] = nums[i] * numbers1[i - 1];
        }
        result[length - 1] = numbers1[length - 2];
        numbers2[length - 1] = nums[length - 1];
        for (int i = length - 2; i > 0; i--) {
            numbers2[i] = nums[i] * numbers2[i + 1];
            result[i] = numbers1[i - 1] * numbers2[i + 1];
        }
        result[0] = numbers2[1];
        return result;
    }
}
