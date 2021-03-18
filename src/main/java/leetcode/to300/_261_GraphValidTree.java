package leetcode.to300;

import java.util.*;

/**
 * Subject: DFS, Union Find
 * #Medium #Attention
 */
public class _261_GraphValidTree {

    //Preferred solution.
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) return true;
        if (n < 1 || edges == null || edges.length != n - 1) return false;

        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }

        for (int[] pair : edges) {
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            if (x == y) return false;
            roots[x] = y;
        }
        return true;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }

    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        boolean res = helper(graph, visited, 0, -1);
        if (res == false) return false;
        return visited.size() == n;
    }

    private boolean helper(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
        List<Integer> sub = graph.get(node);
        for (int v : sub) {
            if (v == parent) continue;
            if (visited.contains(v)) return false;
            visited.add(v);
            boolean res = helper(graph, visited, v, node);
            if (!res) return false;
        }
        return true;
    }

    //Provide a third solution (Preferred)
    public boolean validTree3(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Integer> visited = new HashSet<>();

        boolean res = helper(graph, visited, 0, -1);
        return res && visited.size() == n;
    }

    private boolean dfs(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
        visited.add(node);
        List<Integer> sub = graph.get(node);
        for (int v : sub) {
            if (visited.add(v)) {
                if (!dfs(graph, visited, v, node)) return false;
            } else if (v != parent) {
                return false;
            }
        }
        return true;
    }

    //Provide a forth solution (Preferred) - dfs
    public boolean validTree4(int n, int[][] edges) {
        if (edges.length == 0) return n == 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(edges[0][0], map, visited, -1) && n == visited.size();
    }

    private boolean dfs (Integer node, Map<Integer, List<Integer>> map, Set<Integer> visited, Integer parent) {
        visited.add(node);
        for (int next : map.get(node)) {
            if (visited.contains(next)) {
                if (next != parent) {
                    return false;
                }
            } else {
                if (!dfs(next, map, visited, node)) {
                    return false;
                }
            }
        }
        return true;

    }

    //Provide a fifth solution (Preferred) - Union find
    public boolean validTree5(int n, int[][] edges) {

        if (n != edges.length + 1) return false;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (!union(parent, edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }

    private boolean union(int[] parent, int x, int y) {
        int rootX = findRoot(parent, x);
        int rootY = findRoot(parent, y);
        if (rootX == rootY) {
            return false;
        }
        parent[rootX] = rootY;
        return true;
    }

    private int findRoot(int[] parent, int A) {
        while(parent[A] != A) {
            A = parent[A];
        }
        return A;
    }




/* One of official solution*/
//    class UnionFind {
//
//        private int[] parent;
//
//        // For efficiency, we aren't using makeset, but instead initialising
//        // all the sets at the same time in the constructor.
//        public UnionFind(int n) {
//            parent = new int[n];
//            for (int node = 0; node < n; node++) {
//                parent[node] = node;
//            }
//        }
//
//        // The find method, without any optimizations. It traces up the parent
//        // links until it finds the root node for A, and returns that root.
//        public int find(int A) {
//            while (parent[A] != A) {
//                A = parent[A];
//            }
//            return A;
//        }
//
//        // The union method, without any optimizations. It returns True if a
//        // merge happened, False if otherwise.
//        public boolean union(int A, int B) {
//            // Find the roots for A and B.
//            int rootA = find(A);
//            int rootB = find(B);
//            // Check if A and B are already in the same set.
//            if (rootA == rootB) {
//                return false;
//            }
//            // Merge the sets containing A and B.
//            parent[rootA] = rootB;
//            return true;
//        }
//    }
//
//    class Solution {
//
//        public boolean validTree(int n, int[][] edges) {
//
//            // Condition 1: The graph must contain n - 1 edges.
//            if (edges.length != n - 1) return false;
//
//            // Condition 2: The graph must contain a single connected component.
//            // Create a new UnionFind object with n nodes.
//            UnionFind unionFind = new UnionFind(n);
//            // Add each edge. Check if a merge happened, because if it
//            // didn't, there must be a cycle.
//            for (int[] edge : edges) {
//                int A = edge[0];
//                int B = edge[1];
//                if (!unionFind.union(A, B)) {
//                    return false;
//                }
//            }
//
//            // If we got this far, there's no cycles!
//            return true;
//        }
//
//    }
}
