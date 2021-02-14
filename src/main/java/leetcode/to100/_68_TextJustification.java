package leetcode.to100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 * Subject: String, Two Pointer, Math
 * #Hard #hard
 */
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

    //Provide a second solution (Preferred)
    //中文讲解：https://leetcode-cn.com/problems/text-justification/solution/text-justification-by-ikaruga/
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();
            int count = 0;
            int start = 0;
            for (int end = 0; end < words.length; end++) {
                count += words[end].length() + 1;
                if(end == words.length - 1 || count + words[end + 1].length() > maxWidth) {
                    res.add(generateLine(words, maxWidth, start, end, end == words.length - 1));
                    start = end + 1;
                    count = 0;
                }
            }
            return res;
        }

        private String generateLine(String[] words, int maxWidth, int start, int end, boolean isLastLine) {
            int wordCount = end - start + 1;
            int spaceCount = maxWidth + 1 - wordCount;
            for (int i = start; i <= end; i++) {
                spaceCount -= words[i].length();
            }
            int spaceSuffix = 1;
            int spaceAvg = (wordCount == 1) ? 1 : spaceCount / (wordCount - 1);
            int spaceTotalExtra = (wordCount == 1) ? 0 : spaceCount % (wordCount - 1);
            StringBuilder sb = new StringBuilder();
            for(int i = start; i < end; i++) {
                sb.append(words[i]);
                if (isLastLine) {
                    sb.append(' ');
                    continue;
                }
                int extra = i - start < spaceTotalExtra ? 1 : 0;
                int space = spaceSuffix + spaceAvg + extra;
                for (int j = 0; j < space; j++) {
                    sb.append(' ');
                }
            }
            sb.append(words[end]);
            for (int i = sb.length(); i < maxWidth; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }
}
