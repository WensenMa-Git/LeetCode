package leetcode.to100;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Subject: Binary Search
 * #Medium #Attention
 */
public class _34_SearchforaRange {

    //Preferred solution.
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        binarySearchLeft(nums,0,nums.length-1,target, res);
        binarySearchRight(nums,0,nums.length-1,target, res);
        return res;
    }

    private void binarySearchLeft(int[] nums, int left, int right, int target, int[] res){
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        //right is the index where [right] just smaller than target
        if ((right + 1 != nums.length) && nums[right + 1] == target) {
            res[0] = right + 1;
        } else {
            res[0] = -1;
        }
    }

    private void binarySearchRight(int[] nums, int left, int right, int target, int[] res){
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        //left is the index where [left] just bigger than target
        if (left > 0 && nums[left - 1] == target) {
            res[1] = left - 1;
        } else {
            res[1] = -1;
        }
    }


    public int[] searchRange2(int[] nums, int target) {
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

    //Provide a third solution (Preferred)
    public int[] searchRange3(int[] nums, int target) {
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
