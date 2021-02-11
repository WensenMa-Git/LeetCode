package to600;


public class _547_FriendCircles {


    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int res = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < visited.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum2(int[][] M) {
        int res = M.length;

        int[] roots = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            roots[i] = -1;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    int x = find(roots, i);
                    int y = find(roots, j);
                    if (x != y) {
                        roots[x] = y;
                        res--;
                    }
                }
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
