package to400;


public class _323_NumberofConnectedComponentsinanUndirectedGraph {

    public int countComponents(int n, int[][] edges) {

        int res = n;

        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }

        for (int[] pair : edges) {
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            if (x != y) {
                roots[x] = y;
                res--;
            }
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }
}
