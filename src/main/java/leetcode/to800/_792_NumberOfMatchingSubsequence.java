package leetcode.to800;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 * Subject: String
 * #Medium #Google
 */
public class _792_NumberOfMatchingSubsequence {

    //Fastest solution.
    public int numMatchingSubseq(String S, String[] words) {

        Map<Character, Deque<String>> map = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<String>());
        }

        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }

    //Provide a second solution. (Preferred)
    public int numMatchingSubseq2(String s, String[] words) {
        if(s.length()==0) return 1;
        if(words.length==0) return 0;

        int count = 0;
        HashMap<String,Boolean> hm = new HashMap<>();

        for (String word : words) {
            if (hm.containsKey(word)) {
                boolean flag = hm.get(word);
                if (flag) count++;
            } else {
                if (IsSubsequence(s, word)) {
                    hm.put(word, true);
                    count++;
                } else {
                    hm.put(word, false);
                }
            }
        }
        return count;
    }

    //Provide a third solution.
    public int numMatchingSubseq3(String s, String[] words) {
        if(s.length()==0) return 1;
        if(words.length==0) return 0;

        int count = 0;

        for (String word : words) {
            if (IsSubsequence(s, word)) {
                count++;
            }
        }

        return count;
    }

    public static boolean IsSubsequence(String s,String n) {
        int indexS = 0;
        int indexN = 0;
        while(indexS <= s.length() && indexN <= n.length()) {
            if (indexN == n.length()) {
                return true;
            }
            if (indexS == s.length()) {
                return false;
            }
            if (s.charAt(indexS) == n.charAt(indexN)) {
                indexS++;
                indexN++;
            } else {
                indexS++;
            }
        }
        return false;
    }

}
