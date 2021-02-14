package leetcode.to500;


public class _457_CircularArrayLoop {


    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = getIndex(i, nums);
            while (nums[fast] * nums[i] > 0 && nums[getIndex(fast, nums)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == getIndex(slow, nums)) {
                        break;
                    }
                    return true;
                }
                slow = getIndex(slow, nums);
                fast = getIndex(getIndex(fast, nums), nums);
            }
            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int next = getIndex(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }

    private int getIndex(int i, int[] nums) {
        int len = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % len : len + (i + nums[i]) % len;
    }

}
