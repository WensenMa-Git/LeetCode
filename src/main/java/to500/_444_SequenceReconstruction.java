package to500;

import java.util.List;


public class _444_SequenceReconstruction {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int[] idx = new int[org.length + 1];
        int res = org.length - 1;
        for (int i = 0; i < org.length; i++) {
            idx[org[i]] = i;
        }
        boolean[] seen = new boolean[org.length + 1];
        boolean isEmpty = true;
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                isEmpty = false;
                int cur = seq.get(i);
                if (cur < 1 || cur > org.length) {
                    return false;
                }
                if (i == 0) continue;
                int prev = seq.get(i - 1);
                if (idx[prev] + 1 == idx[cur]) {
                    if (!seen[prev]) {
                        seen[prev] = true;
                        res--;
                    }
                } else if (idx[prev] >= idx[cur]) {
                    return false;
                }
            }
        }
        return res == 0 && !isEmpty;
    }
}
