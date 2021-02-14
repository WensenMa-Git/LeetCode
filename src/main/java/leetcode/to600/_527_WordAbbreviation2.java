package leetcode.to600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class _527_WordAbbreviation2 {


    public List<String> wordsAbbreviation(List<String> dict) {
        HashMap<String, List<IndexedWord>> map = new HashMap();
        String[] res = new String[dict.size()];

        int index = 0;
        for (String word : dict) {
            String abbr = abbrev(word, 0);
            if (!map.containsKey(abbr)) {
                map.put(abbr, new ArrayList());
            }
            map.get(abbr).add(new IndexedWord(word, index));
            index++;
        }

        for (List<IndexedWord> indexedWords : map.values()) {
            TrieNode root = new TrieNode();
            for (IndexedWord iw : indexedWords) {
                TrieNode cur = root;
                for (char letter : iw.word.substring(1).toCharArray()) {
                    if (cur.children[letter - 'a'] == null)
                        cur.children[letter - 'a'] = new TrieNode();
                    cur.count++;
                    cur = cur.children[letter - 'a'];
                }
            }

            for (IndexedWord iw : indexedWords) {
                TrieNode cur = root;
                int i = 1;
                for (char letter : iw.word.substring(1).toCharArray()) {
                    if (cur.count == 1) break;
                    cur = cur.children[letter - 'a'];
                    i++;
                }
                res[iw.index] = abbrev(iw.word, i - 1);
            }
        }

        return Arrays.asList(res);
    }

    public String abbrev(String word, int i) {
        int n = word.length();
        if (n - i <= 3) {
            return word;
        }
        return word.substring(0, i + 1) + (n - i - 2) + word.charAt(n - 1);
    }

    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }

    class IndexedWord {
        String word;
        int index;

        IndexedWord(String w, int i) {
            word = w;
            index = i;
        }
    }

}
