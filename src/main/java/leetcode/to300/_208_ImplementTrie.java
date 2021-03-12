package leetcode.to300;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Subject: Trie Tree
 * #Medium
 */
public class _208_ImplementTrie {

    TrieNode root;

    public _208_ImplementTrie() {
        root = new TrieNode();
    }

    // time : O(n)  n: word.length();
    // O(num of TrieNode * 26) = O(num of Words * word.length() * 26)

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
    }


    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) return false;
            node = node.children[j];
        }
        return node.isWord;
    }


    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (node.children[j] == null) return false;
            node = node.children[j];
        }
        return true;
    }

    class TrieNode {

        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }

    //Provide a second solution (Preferred)
    class Trie {
        class TrieNode {
            char val;
            boolean isWord;
            TrieNode[] children = new TrieNode[26];

            TrieNode() { }
            TrieNode(char val) {
                this.val = val; }
        }

        private final TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (node.children[cur - 'a'] == null) {
                    node.children[cur - 'a'] = new TrieNode(cur);
                }
                node = node.children[cur - 'a'];
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (node.children[cur - 'a'] == null) return false;
                node = node.children[cur - 'a'];
            }
            return node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char cur = prefix.charAt(i);
                if (node.children[cur - 'a'] == null) return false;
                node = node.children[cur - 'a'];
            }
            return true;
        }

        public List<String> startsWith2(String prefix) {
            List<String> res = new ArrayList<>();
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char cur = prefix.charAt(i);
                if (node.children[cur - 'a'] == null) return res;
                node = node.children[cur - 'a'];
            }
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            helper(res, node, sb);
            return res;
        }

        private void helper(List<String> res, TrieNode node, StringBuilder sb) {
            if (node.isWord) {
                res.add(sb.toString());
            }
            for (int i = 0; i < 26; i++) {
                if (node.children[i] == null) continue;
                sb.append(node.children[i].val);
                helper(res, node.children[i], sb);
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }
}