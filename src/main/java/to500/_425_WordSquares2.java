package to500;

import java.util.ArrayList;
import java.util.List;


public class _425_WordSquares2 {


    TrieNode root;

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        root = new TrieNode();
        buildTrie(words);
        findSquare(res, new ArrayList<>(), words[0].length());
        return res;
    }

    private void findSquare(List<List<String>> res, List<String> candidate, int len) {
        if (candidate.size() == len) {
            res.add(new ArrayList<>(candidate));
            return;
        }
        int index = candidate.size();
        StringBuilder sb = new StringBuilder();
        for (String s : candidate) {
            sb.append(s.charAt(index));
        }
        String s = sb.toString();
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            if (node.next[s.charAt(i) - 'a'] != null) {
                node = node.next[s.charAt(i) - 'a'];
            } else {
                node = null;
                break;
            }
        }
        if (node != null) {
            for (String next : node.words) {
                candidate.add(next);
                findSquare(res, candidate, len);
                candidate.remove(candidate.size() - 1);
            }
        }
    }

    private void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            char[] array = word.toCharArray();
            for (char c : array) {
                node.words.add(word);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.words.add(word);
        }
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        List<String> words = new ArrayList<>();
    }
}
