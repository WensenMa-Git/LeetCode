package leetcode.to500;

import java.util.*;


public class _444_SequenceReconstruction2 {


    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i : seq) {
                map.putIfAbsent(i, new HashSet<>());
                indegree.putIfAbsent(i, 0);
            }
        }

        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) continue;
            for (int i = 1; i < seq.size(); i++) {
                if (map.get(seq.get(i - 1)).add(seq.get(i))) {
                    indegree.put(seq.get(i), indegree.get(seq.get(i) + 1));
                }
            }
        }

        if (org.length != indegree.size()) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        int res = 0;
        while (queue.size() == 1) {
            for (int next : map.get(queue.poll())) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
            res++;
        }
        return res == indegree.size();
    }

}
