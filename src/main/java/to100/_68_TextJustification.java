package to100;

import java.util.ArrayList;
import java.util.List;


public class _68_TextJustification {

    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1;
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k > 0; k--) {
                        builder.append(" ");
                    }
                    if (r > 0) {
                        builder.append(" ");
                        r--;
                    }
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }
            res.add(builder.toString());
            index = last;
        }
        return res;
    }
}
