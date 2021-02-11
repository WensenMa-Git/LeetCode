package to500;


public class _466_CountTheRepetitions {


    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count1 = 0, count2 = 0, i = 0, j = 0;

        while (count1 < n1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                if (j == s2.length()) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == s1.length()) {
                i = 0;
                count1++;
            }
        }

        return count2 / n2;
    }


    public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
        int[] repeatCnt = new int[n1 + 1];
        int[] nextIdx = new int[n1 + 1];
        int j = 0, count = 0;
        for (int k = 1; k <= n1; k++) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == s2.length()) {
                        j = 0;
                        count++;
                    }
                }
            }
            repeatCnt[k] = count;
            nextIdx[k] = j;
            for (int start = 0; start < k; start++) {
                if (nextIdx[start] == j) {
                    int prefixCount = repeatCnt[start];
                    int patternCount = (n1 - start) / (k - start) * (repeatCnt[k] - prefixCount);
                    int suffixCount = repeatCnt[start + (n1 - start) % (k - start)] - prefixCount;
                    return (prefixCount + patternCount + suffixCount) / n2;
                }
            }
        }
        return repeatCnt[n1] / n2;
    }
}
