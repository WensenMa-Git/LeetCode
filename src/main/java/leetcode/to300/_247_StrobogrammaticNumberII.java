package leetcode.to300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 * Subject: Recursion
 * #Medium
 */
public class _247_StrobogrammaticNumberII {

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }

    //Provide a second solution. (Preferred)
    class Solution {

        char[] nums;
        char[][] pairs;
        List<String> answer;

        private void generateStrobogrammaticNumber (int left, int right) {

            if (left > right) {
                answer.add (new String (nums));
                return;
            }

            for (char[] pair : pairs) {
                if (left == 0 && left != right && pair[0] == '0') {
                    continue;
                }
                else if (left == right && pair[0] != pair[1]) {
                    continue;
                }

                nums[left] = pair[0];
                nums[right] = pair[1];

                generateStrobogrammaticNumber (left + 1, right - 1);
            }
        }

        public List<String> findStrobogrammatic(int n) {

            nums = new char[n];
            pairs = new char[][] { {'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'} };
            answer = new ArrayList<> ();

            generateStrobogrammaticNumber (0, n - 1);
            return answer;
        }
    }
}
