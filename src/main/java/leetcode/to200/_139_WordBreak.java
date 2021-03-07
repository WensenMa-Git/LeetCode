package leetcode.to200;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 * Subject: Dynamic Programming
 * #Medium
 */
public class _139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        int maxWordLen = 0;
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
            maxWordLen = Math.max(maxWordLen, word.length());
        }
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && i - j <= maxWordLen; j--) {
                if (canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
