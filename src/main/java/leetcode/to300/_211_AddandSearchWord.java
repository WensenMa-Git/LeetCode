package leetcode.to300;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 * Subject: Trie Tree
 * #Medium
 */
public class _211_AddandSearchWord {

    private final TrieNode root;

    public _211_AddandSearchWord() {
        root = new TrieNode();
    }

    // time : O(n)  n: word.length();
    // O(num of TrieNode * 26) = O(num of Words * word.length() * 26)
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
        node.word = word;
    }


    public boolean search(String word) {
        return find(word, root, 0);
    }

    public boolean find(String word, TrieNode node, int index) {
        if (index == word.length()) return node.isWord;//!node.word.equals("");
        if (word.charAt(index) == '.') {
            for (TrieNode temp : node.children) {
                if (temp != null && find(word, temp, index + 1)) return true;
            }
            return false;
        } else {
            int j = word.charAt(index) - 'a';
            TrieNode temp = node.children[j];
            return temp != null && find(word, temp, index + 1);
        }
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
    class WordDictionary {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
        }

        /** Initialize your data structure here. */
        private TrieNode root;
        public WordDictionary() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return search(word, root, 0);
        }

        private boolean search(String word, TrieNode curr, int pos) {
            for (int i = pos; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (curr.children[j] == null) continue;
                        if (search(word, curr.children[j], i + 1)) return true;
                    }
                    return false;
                }

                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) return false;
                curr = curr.children[idx];
            }
            return curr.isWord;
        }

    }
}
