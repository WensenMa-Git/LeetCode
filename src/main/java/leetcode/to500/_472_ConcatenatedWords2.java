package leetcode.to500;

import java.util.ArrayList;
import java.util.List;


public class _472_ConcatenatedWords2 {

    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        build(words);
        for (String word : words) {
            if (search(word, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    public void build(String[] dict) {
        for (String word : dict) {
            if (word == null || word.length() == 0) continue;
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
    }

    public boolean search(String word, int index, int count) {
        TrieNode cur = root;
        for (int i = index; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.children[word.charAt(i) - 'a'];
            if (cur.isWord && search(word, i + 1, count + 1)) {
                return true;
            }
        }
        return count >= 1 && cur.isWord;
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
}
