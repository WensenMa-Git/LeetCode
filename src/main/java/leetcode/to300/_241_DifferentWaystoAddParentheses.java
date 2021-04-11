package leetcode.to300;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 * Subject: Recursion, Divide
 * #Medium #Hard
 */
public class _241_DifferentWaystoAddParentheses {

    //Preferred solution
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    //Provide a second solution.
    //https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/fen-zhi-by-suns-u-029f/
    class Solution {
        char[] cArr;
        int len;
        List<Integer> res = new ArrayList<Integer>();
        public List<Integer> diffWaysToCompute(String input) {
            this.cArr = input.toCharArray();
            this.len = input.length();
            return dfsHelper(0, len - 1);
        }
        private List<Integer> dfsHelper(int l, int r) {
            int idx = l, num = cArr[idx] - '0';
            List<Integer> nArr = new ArrayList<Integer>();
            while ((idx + 1 <= r) && Character.isDigit(cArr[idx + 1])) {
                idx++;
                num = num * 10 + (cArr[idx] - '0');
            }
            if (idx == r) {nArr.add(num); return nArr;}
            for (int i = idx + 1; i <= r; i++) {
                if (Character.isDigit(cArr[i])) continue;
                List<Integer> left = this.dfsHelper(l, i - 1);
                List<Integer> right = this.dfsHelper(i + 1, r);
                for (int val_l : left) {
                    for (int val_r : right) {
                        char opt = cArr[i]; int output = 0;
                        if (opt == '+') output = val_l + val_r;
                        else if (opt == '-') output = val_l - val_r;
                        else if (opt == '*') output = val_l * val_r;
                        nArr.add(output);
                    }
                }
            }
            return nArr;
        }
    }

}
