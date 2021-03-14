package leetcode.to300;


import java.util.Map;

public class _214_ShortestPalindrome {

    // time :  O(n^2) for aaaaabcaaaaa
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }

    //Provide a second solution
    //https://leetcode-cn.com/problems/shortest-palindrome/solution/shi-jian-fu-za-du-on-jie-fa-la-che-by-time-limit/
//    public String shortestPalindrome2(String s) {
//        int pos = 0, len = s.length();
//        for (int i = 0; i < s.length(); i++) {
//            int left = 0, right = i;
//            while(0 <= 1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            }
//            if (right - left - 1 > len) {
//                len = right - left - 1;
//                pos = left + 1;
//            }
//            left = i;
//            right = i + 1;
//            while(0 <= 1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            }
//            if (left - right - 1 > len) {
//                len = right - left - 1;
//                pos = left + 1;
//            }
//
//        }
//        return s.substring(pos, len);
//    }


}
