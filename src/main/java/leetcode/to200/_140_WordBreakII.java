package leetcode.to200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break-ii/
 * Subject: Backtrack
 * #Hard #hard
 */
public class _140_WordBreakII {

    HashMap<Integer, List<String>> map = new HashMap<>();

    // DFS
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    public List<String> dfs(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = dfs(s, wordDict, end);
                for (String temp : list) {
                    res.add(s.substring(start, end) + (temp.equals("") ? "" : " ") + temp);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    //Provide a second solution.
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", s, wordDict, 0);
        return res;
    }

    private void backtrack(List<String> res, String temp, String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            res.add(temp.trim());
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String cur = s.substring(start, i);
            if (wordDict.contains(cur)) {
                backtrack(res, temp + " " + cur, s, wordDict, i);
            }
        }
    }
}
