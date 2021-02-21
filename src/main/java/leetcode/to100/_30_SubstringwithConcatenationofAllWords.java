package leetcode.to100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * Subject: String, Sliding Window.
 * #Hard #hard
 */
public class _30_SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        int wordCounts = words.length;
        int oneWordLength = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i <= s.length() - wordCounts * oneWordLength; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = wordCounts;
            int j = i;
            while (k > 0) {
                String str = s.substring(j, j + oneWordLength);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += oneWordLength;
            }
            if (k == 0) res.add(i);
        }
        return res;
    }

    //Provide a second solution (time complexity is O(n2)) (Preferred)
    //https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-powcai/
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - all_len; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }

    //Provide a third solution (time complexity is O(n)) (fastest solution)
    //https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-powcai/
    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                right += one_word;
                count++;
                while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    String t_w = s.substring(left, left + one_word);
                    count--;
                    tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                    left += one_word;
                }
                if (count == word_num) res.add(left);
            }
        }
        return res;
    }

}
