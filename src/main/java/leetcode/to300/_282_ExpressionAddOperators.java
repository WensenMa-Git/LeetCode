package leetcode.to300;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expression-add-operators/
 * Subject: Backtrack
 * #Hard #hard #Attention
 */
public class _282_ExpressionAddOperators {


    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }

    private void helper(List<String> res, String path, String num, int target, int pos, long val, long pre) {
        if (pos == num.length()) {
            if (target == val) {
                res.add(path);
                return;
            }
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(res, path + "+" + cur, num, target, i + 1, val + cur, cur);
                helper(res, path + "-" + cur, num, target, i + 1, val - cur, -cur);
                helper(res, path + "*" + cur, num, target, i + 1, val - pre + pre * cur, pre * cur);
            }
        }
    }

    //Preferred solution.
    //https://leetcode-cn.com/problems/expression-add-operators/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-52/
    public List<String> addOperators2(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperatorsHelper(num, target, result, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void addOperatorsHelper(String num, int target, List<String> result, StringBuilder path, int start, long eval, long pre) {
        if (start == num.length()) {
            if (target == eval) {
                result.add(path.toString());
            }
            return;

        }
        for (int i = start; i < num.length(); i++) {
            // 数字不能以 0 开头
            if (num.charAt(start) == '0' && i > start) {
                break;
            }
            long cur = Long.parseLong(num.substring(start, i + 1));
            int len = path.length();
            if (start == 0) {
                addOperatorsHelper(num, target, result, path.append(cur), i + 1, cur, cur);
                path.setLength(len);
            } else {

                // 加当前值
                addOperatorsHelper(num, target, result, path.append("+").append(cur), i + 1, eval + cur, cur);
                path.setLength(len);
                // 减当前值
                addOperatorsHelper(num, target, result, path.append("-").append(cur), i + 1, eval - cur, -cur);
                path.setLength(len);
                // 乘当前值
                addOperatorsHelper(num, target, result, path.append("*").append(cur), i + 1, eval - pre + pre * cur,
                        pre * cur);
                path.setLength(len);
            }
        }
    }

}
