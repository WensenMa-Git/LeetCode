package leetcode.to500;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class _433_MinimumGeneticMutation {


    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }

        HashSet<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return level;
                }

                char[] curArray = cur.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char old = curArray[i];
                    for (char c : charSet) {
                        curArray[i] = c;
                        String next = new String(curArray);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
