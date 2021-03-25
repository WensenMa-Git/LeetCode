package leetcode.to200;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/majority-element/
 * Subject: Array, Majority
 * #Easy
 */
public class _169_MajorityElement {


    // time : O(nlogn) space : O(1)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // time : O(n) space : O(n)
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                res = num;
                break;
            }
        }
        return res;
    }

    // Moore voting algorithm
    // 每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素。
    // 不难证明，如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e。
    // [1,2,3,3,3]
    // time : O(n) space : O(1)
    public int majorityElement3(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num != res) {
                count--;
            } else count++;
        }
        return res;
    }

    //Provide a forth solution (Preferred).
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(candidate == nums[i]){
                count++;
            }else if(count == 0){
                candidate = nums[i];
                count = 1;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
