package leetcode.to300;


public class _289_GameofLife {

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbor(board, i, j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;
                    }
                } else if (count == 3) {
                    board[i][j] += 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int countNeighbor(int[][] board, int i, int j) {
        int count = 0;
        for (int row = Math.max(0, i - 1); row <= Math.min(i + 1, board.length - 1); row++) {
            for (int col = Math.max(0, j - 1); col <= Math.min(j + 1, board[0].length - 1); col++) {
                if (row == i && col == j) continue;
                if ((board[row][col] & 1) == 1) count++;
            }
        }
        return count;
    }

    //Provide a second solution. (Preferred)
    public void gameOfLife2(int[][] board) {
        int m = board.length, n = m == 0 ? 0 : board[0].length;
        if(m == 0 || n == 0) return;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int nb = getNB(board, i, j);
                if(board[i][j] == 1 && (nb == 2 || nb == 3)) board[i][j] = 3;
                else if(board[i][j] == 0 && nb == 3) board[i][j] = 2;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                board[i][j] >>>= 1;
        }
    }
    private int getNB(int[][] board, int i, int j) {
        int cnt = 0;
        for(int r = -1; r < 2; r++) {
            for(int c = -1; c < 2; c++) {
                int x = r + i, y = c + j;
                if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
                cnt += board[x][y] & 1;
            }
        }
        cnt -= board[i][j] & 1;
        return cnt;
    }
}
