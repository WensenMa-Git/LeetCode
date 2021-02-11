package to600;


public class _526_BeautifulArrangement {


    int res;

    public int countArrangement(int N) {
        res = 0;
        helper(new boolean[N + 1], N, 1);
        return res;
    }

    public void helper(boolean[] visited, int N, int pos) {
        if (pos > N) {
            res++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                helper(visited, N, pos + 1);
                visited[i] = false;
            }
        }
    }
}
