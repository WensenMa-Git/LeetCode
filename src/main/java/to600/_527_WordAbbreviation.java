package to600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class _527_WordAbbreviation {


    public List<String> wordsAbbreviation(List<String> dict) {
        int n = dict.size();
        String[] res = new String[n];
        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = abbr(dict.get(i), 0);
        }

        for (int i = 0; i < n; i++) {
            while (true) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = i + 1; j < n; j++) {
                    if (res[i].equals(res[j])) {
                        set.add(j);
                    }
                }
                if (set.isEmpty()) break;
                set.add(i);
                for (int k : set) {
                    res[k] = abbr(dict.get(k), ++prefix[k]);
                }
            }
        }

        return Arrays.asList(res);
    }

    private String abbr(String word, int i) {
        int n = word.length();
        if (n - i <= 3) {
            return word;
        }
        return word.substring(0, i + 1) + (n - i - 2) + word.charAt(n - 1);
    }

}
