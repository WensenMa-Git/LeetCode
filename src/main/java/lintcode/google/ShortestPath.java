package lintcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 給定一個圖，輸入形式是一群邊，輸出指定起點A到終點B的最短路徑
 * Input:
 * [[1, 2], [2, 3]], A = 1, B = 3
 *
 * Output:
 * 2
 *
 * Follow-up: 若開車從A到B，油箱一開始有V單位油，每走一個邊就用掉一單位，用完就不能再前進，在這之前有經過加油站的話可以把油加滿，一樣求最短路徑
 *
 * 用BFS解即可
 */
public class ShortestPath {

    //BFS
    public int getShortestPath(int[][] paths, int A, int B) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] path : paths) {
            map.putIfAbsent(path[0], new ArrayList<>());
            map.get(path[0]).add(path[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(A);
        visited.add(A);
        int pathLevel = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            pathLevel++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == B) {
                    return pathLevel;
                }
                if (map.get(cur) == null) {
                    continue;
                }
                for (int next : map.get(cur)) {
                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    //DFS
    public int getShortestPath2(int[][] paths, int A, int B) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] path : paths) {
            map.putIfAbsent(path[0], new ArrayList<>());
            map.get(path[0]).add(path[1]);
        }

        Set<Integer> visited = new HashSet<>();
        int[] res = new int[]{-1};
        dfs(map, A, B, 0, visited, res);
        return res[0];
    }

    private void dfs(Map<Integer, List<Integer>> map, int cur, int target, int level, Set<Integer> visited, int[] res) {
        if (res[0] != -1) {
            return;
        }
        if (cur == target) {
            res[0] = level;
            return;
        }
        visited.add(cur);
        if (map.get(cur) == null) {
            return;
        }
        for (int next : map.get(cur)) {
            if (visited.contains(next)) continue;
            dfs(map, next, target, level + 1, visited, res);
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2}, {2, 4}};
        System.out.println(new ShortestPath().getShortestPath2(array, 1, 4));
    }

}
