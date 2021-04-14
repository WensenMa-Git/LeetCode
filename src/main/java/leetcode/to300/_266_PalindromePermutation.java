package leetcode.to300;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/palindrome-permutation/
 * Subject: Array
 * #Easy
 */
public class _266_PalindromePermutation {

    //Provide a new solution. (Preferred)
    public boolean canPermutePalindrome(String s) {
        boolean[] odd = new boolean[256];
        int oddCount = 0;
        for (char c : s.toCharArray()) {
            odd[c] = !odd[c];
            if (odd[c]) {
                oddCount++;
            } else {
                oddCount--;
            }
        }
        return oddCount <= 1;
    }

    //space : O(n)
    public boolean canPermutePalindrome1(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    //space : O(1)
    public boolean canPermutePalindrome2(String s) {
        char[] count = new char[256];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) res++;
        }
        return res <= 1;
    }
}
