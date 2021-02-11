package to300;


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
}