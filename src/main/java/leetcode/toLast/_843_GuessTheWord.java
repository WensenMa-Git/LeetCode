package leetcode.toLast;

import java.util.*;

/**
 * https://leetcode.com/problems/guess-the-word/
 * Subject: Array
 * #Hard #Google
 */
public class _843_GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = new LinkedList<>(Arrays.asList(wordlist));
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(list.size());
            String guess = list.get(index);
            int k = master.guess(guess);
            if (k == 6) return;

            list.removeIf(cur -> similarity(cur, guess) != k);
        }
    }

    private int similarity(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    class Master {
        public int guess(String s) {
            return 1;
        }
    }
}
