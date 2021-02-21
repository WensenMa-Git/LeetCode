package leetcode.to100;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Subject: Binary Search
 * #Medium #Attention
 */
public class _34_SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = findFirst(nums, target);
        if (start == -1) {
            return new int[]{-1, -1};
        }
        int end = findLast(nums, target);
        return new int[]{start, end};
    }

    public int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    public int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }

    //Provide a second solution (Preferred)
    public int[] searchRange2(int[] nums, int target) {
        int res[] = new int[2];
        int left= binarySearchLeft(nums,0,nums.length-1,target,-1);
        int right = binarySearchRight(nums,0,nums.length-1,target,-1);
        res[0]=left;
        res[1]=right;
        return res;

    }

    private int binarySearchLeft(int[] nums, int left, int right, int target, int res){
        if(left > right) return res;
        int mid = (left + right)/2;
        if(target == nums[mid]) {
            return binarySearchLeft(nums,left,mid-1,target,mid);
        }
        if(target > nums[mid]) {
            return binarySearchLeft(nums,mid+1,right,target,res);
        }else{
            return binarySearchLeft(nums,left,mid-1,target,res);
        }
    }

    private int binarySearchRight(int[] nums, int left, int right, int target, int res){
        if(left > right) return res;
        int mid = (left + right)/2;
        if(target == nums[mid]) {
            return binarySearchRight(nums,mid+1,right,target,mid);
        }
        if(target > nums[mid]) {
            return binarySearchRight(nums,mid+1,right,target,res);
        }else{
            return binarySearchRight(nums,left,mid-1,target,res);
        }
    }
}
