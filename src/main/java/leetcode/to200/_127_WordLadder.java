package leetcode.to200;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 * Subject: BFS
 * #Hard
 */
public class _127_WordLadder {

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return level + 1;
                        }
                        nextNum++;
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }

    //Provide a second solution (Preferred)
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int curLevel = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return curLevel + 1;
                        }
                        map.put(temp, curLevel + 1);
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }

    //Provide a third solution (Preferred)
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        int curLevel = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            curLevel++;
            for (int s = 0; s < size; s++) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    char[] wordUnit = word.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        wordUnit[i] = j;
                        String temp = new String(wordUnit);
                        if (set.contains(temp)) {
                            if (temp.equals(endWord)) {
                                return curLevel + 1;
                            }
                            queue.offer(temp);
                            set.remove(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }

    //Provide a fourth solution (Preferred)
    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        int curLevel = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            curLevel++;
            for (int s = 0; s < size; s++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return curLevel;
                }
                for (int i = 0; i < word.length(); i++) {
                    char[] wordUnit = word.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        wordUnit[i] = j;
                        String temp = new String(wordUnit);
                        if (set.contains(temp)) {
                            queue.offer(temp);
                            set.remove(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
