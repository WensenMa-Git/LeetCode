package leetcode.to300;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/strobogrammatic-number/
 * Subject: String
 * #Easy
 */
public class _246_StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('8', '8');
        map.put('1', '1');
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left))) {
                return false;
            }
            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //Provide a second solution. (Preferred)
    public boolean isStrobogrammatic2(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('8', '8');
        map.put('1', '1');
        for (int r = num.length() - 1; r >= 0; r--) {
            if (!map.containsKey(num.charAt(r))) {
                return false;
            }
            sb.append(map.get(num.charAt(r)));
        }
        return sb.toString().equals(num);
    }
}
