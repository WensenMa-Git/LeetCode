package leetcode.to500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class _411_MinimumUniqueWordAbbreviation {


    TrieNode root = new TrieNode();

    public String minAbbreviation(String target, String[] dictionary) {
        for (String word : dictionary) {
            addWord(word);
        }
        List<String> abbr = new ArrayList<>();
        addAbbr(abbr, target, "", 0, 0);
        Collections.sort(abbr, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        for (String word : abbr) {
            if (!search(word, root, 0, 0)) {
                return word;
            }
        }
        return "";
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word, TrieNode root, int pos, int count) {
        if (root == null) return false;
        if (count != 0) {
            for (int i = 0; i < 26; i++) {
                if (search(word, root.children[i], pos, count - 1)) return true;
            }
            return false;
        }
        if (pos == word.length()) {
            return root.isWord;
        }
        int i = pos;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') {
                count = count * 10 + c - '0';
                i++;
            } else {
                break;
            }
        }
        if (count == 0) {
            char c = word.charAt(i);
            return search(word, root.children[c - 'a'], i + 1, count);
        }
        return search(word, root, i, count);
    }

    public void addAbbr(List<String> res, String word, String cur, int pos, int count) {
        if (pos == word.length()) {
            if (count != 0) {
                cur += count;
            }
            res.add(cur);
            return;
        }
        // 加数字
        addAbbr(res, word, cur, pos + 1, count + 1);
        if (count != 0) {
            cur += count;
        }
        // 加字母
        addAbbr(res, word, cur + word.charAt(pos), pos + 1, 0);
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
}
