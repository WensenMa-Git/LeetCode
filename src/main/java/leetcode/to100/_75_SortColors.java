package leetcode.to100;


public class _75_SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index++, left++);
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, right--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //Provide a second solution (Preferred)
    public void sortColors2(int[] nums) {
        for(int start = 0, end = nums.length, i = 0; i < end; i++){
            if(nums[i] == 2){
                nums[i--] = nums[--end];
                nums[end] = 2;
            }else if(nums[i] == 0){
                nums[i] = nums[start];
                nums[start++] = 0;
            }
        }
    }
}
