package leetcode.to100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * Subject: Backtrack
 * #Medium #Attension
 */
public class _93_RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, "", 0);
        return res;
    }

    public void helper(List<String> res, String s, int index, String ret, int count) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
            res.add(ret);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) break;
            String temp = s.substring(index, index + i);
            if ((temp.startsWith("0") && temp.length() > 1) || (i == 3 && Integer.parseInt(temp) >= 256)) continue;
            helper(res, s, index + i, ret + temp + (count == 3 ? "" : "."), count + 1);
        }
    }

    //Provide a second solution (Preferred)
    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res, sb, s, 0, 0);
        System.out.println(res);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, String s, int start, int pointNum) {
        if (pointNum == 3) {
            String part = s.substring(start);
            if (isValid(part)) {
                res.add (sb.toString() + part);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String part = s.substring(start, i + 1);
            if (isValid(part)) {
                sb.append(part);
                sb.append('.');
                backtrack(res, sb, s, i + 1, pointNum + 1);
                sb.delete(sb.length() - part.length() - 1, sb.length());
            } else {
                break;
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3) return false;
        int num = Integer.parseInt(s);
        return (s.charAt(0) != '0' || s.length() == 1) && num <= 255;
    }
}
