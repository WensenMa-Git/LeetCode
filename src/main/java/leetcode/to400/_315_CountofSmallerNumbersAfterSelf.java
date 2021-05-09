package leetcode.to400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * Subject:
 * #Hard #Google
 */
public class _315_CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(list, nums[i]);
            res[i] = index;
            list.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }

    private int findIndex(List<Integer> list, int target) {
        if (list.size() == 0) return 0;
        int start = 0;
        int end = list.size() - 1;
        if (list.get(end) < target) return end + 1;
        if (list.get(start) >= target) return 0;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (list.get(start) >= target) return start;
        return end;
    }

    //Provide a second solution. (Preferred)
    public List<Integer> countSmaller2(int[] nums) {
        if(nums.length <= 0) return new ArrayList<>();

        //find min value
        int min = Integer.MAX_VALUE;
        for(int value : nums){
            if(value < min) min = value;
        }

        //how far is each number from min
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1; //how far is each number from min value;
        }

        //find max value
        int max = Integer.MIN_VALUE;
        for(int value : nums) {
            if(value > max) max = value;
        }

        int[] BITree = new int[max + 1];
        BITree[0] = 0;
        int[] countArr = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            int count = getSum(nums[i]-1, BITree);
            countArr[i] = count;
            update(nums[i], BITree);
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int value : countArr)
            result.add(value);
        return result;
    }

    private int getSum(int value, int[] BITree) {
        int sum = 0;
        while(value > 0) {
            sum += BITree[value];
            value -= (value & -value);
        }
        return sum;
    }

    private void update(int value, int[] BITree) {
        while(value <= BITree.length - 1) {
            BITree[value] += 1;
            value += (value & -value);
        }
    }

    //Provide a third solution. (Time Limit Exceeded)
    public List<Integer> countSmaller3(int[] nums) {

        List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> copyNums = new ArrayList<>(temp);
        Collections.sort(copyNums);
        List<Integer> res = new ArrayList<>();
        for (int cur : nums) {
            int index = binarySearch(copyNums, cur);
            System.out.println(index);
            if (index == -1) {
                res.add(0);
            } else {
                res.add(index + 1);
            }
            copyNums.remove(Integer.valueOf(cur));

        }
        return res;

    }

    private int binarySearch(List<Integer> nums, int target) {
        int L = 0, R = nums.size() - 1;
        while (L <= R) {
            int m = (L + R) / 2;
            if (target <= nums.get(m)) {
                R = m - 1;
            } else {
                L = m + 1;
            }
        }
        return R;
    }
}
