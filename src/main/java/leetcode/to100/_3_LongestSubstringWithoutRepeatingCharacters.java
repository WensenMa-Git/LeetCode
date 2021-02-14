package leetcode.to100;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Subject: String, Two Pointer
 * #Medium
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
                i--;
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }

    //Provide a third solution (Preferred)
    public int lengthOfLongestSubstring3(String s) {
        char[] sChars = s.toCharArray();
        boolean[] visited = new boolean[256];
        int len = 0;
        for(int L = 0, R = 0; R < sChars.length; R++){
            while(visited[sChars[R]]){
                visited[sChars[L++]] = false;
            }
            visited[sChars[R]] = true;
            len = Math.max(R - L + 1, len);
        }
        return len;
    }
}

