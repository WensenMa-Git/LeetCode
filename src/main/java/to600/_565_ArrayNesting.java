package to600;


public class _565_ArrayNesting {

    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = i;
            int count = 0;
            while (nums[next] != -1) {
                count++;
                int temp = next;
                next = nums[next];
                nums[temp] = -1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
