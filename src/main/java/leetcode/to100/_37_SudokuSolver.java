package leetcode.to100;

import java.util.ArrayList;
import java.util.List;

public class _37_SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    //Provide a second solution.
    public void solveSudoku2(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] subs = new int[3][3];
        List<Integer> miss = new ArrayList<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i] |= (1 << num);
                    cols[j] |= (1 << num);
                    subs[i / 3][j / 3] |= (1 << num);
                } else {
                    miss.add(i * 9 + j);
                }
            }
        }
        help(board, rows, cols, subs, miss, 0);
    }

    // return true if already find the result
    private boolean help(char[][] board, int[] rows, int[] cols, int[][] subs,
                         List<Integer> miss, int start) {
        if (start == miss.size()) {
            return true;
        }
        int index = miss.get(start);
        int y = index / 9;
        int x = index % 9;
        int full = (1 << 9) - 1;
        int cand = full ^ (rows[y] | cols[x] | subs[y / 3][x / 3]);// all possible candidates we can use
        while (cand > 0) {
            int bit = cand & (-cand);// last 1 bit
            cand -= bit;// since we have used it, we remove this bit
            rows[y] |= bit;
            cols[x] |= bit;
            subs[y / 3][x / 3] |= bit;
            if (help(board, rows, cols, subs, miss, start + 1)) {// if this is the answer, we change the position to correponding number, and return true
                int num = 1 + (int)(Math.log(bit) / Math.log(2));
                board[y][x] = (char)(num + '0');
                return true;
            }
            rows[y] -= bit;
            cols[x] -= bit;
            subs[y / 3][x / 3] -= bit;
        }
        return false;
    }

    //Provide a third solution (Preferred)
    public void solveSudoku3(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] subs = new int[3][3];
        List<Integer> miss = new ArrayList<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i] |= (1 << num);
                    cols[j] |= (1 << num);
                    subs[i / 3][j / 3] |= (1 << num);
                } else {
                    miss.add(i * 9 + j);
                }
            }
        }
        int[] res = new int[miss.size()];
        backtrack(res, miss, rows, cols, subs, 0);
        for (int i = 0; i < miss.size(); i++) {
            int r = miss.get(i) / 9;
            int c = miss.get(i) % 9;
            board[r][c] = (char) (res[i] + '0');
        }
    }

    private boolean backtrack(int[] res, List<Integer> miss, int[] rows, int[] cols, int[][] subs, int index){
        if (index == miss.size()) {
            return true;
        }
        int r = miss.get(index) / 9;
        int c = miss.get(index) % 9;
        int used = rows[r] | cols[c] | subs[r / 3][c / 3];
        for (int candidate = 1; candidate <= 9; candidate++){
            int bitValue = 1 << candidate;
            if ((used & bitValue) > 0) continue;
            rows[r] |= bitValue;
            cols[c] |= bitValue;
            subs[r / 3][c / 3] |= bitValue;
            if (backtrack(res, miss, rows, cols, subs, index + 1)){
                res[index] = candidate;
                return true;
            }
            rows[r] -= bitValue;
            cols[c] -= bitValue;
            subs[r / 3][c / 3] -= bitValue;
        }
        return false;
    }

    //Provide a fourth solution. (This should be used when there are more than one result)
    public void solveSudoku4(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] subs = new int[3][3];
        List<Integer> miss = new ArrayList<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i] |= (1 << num);
                    cols[j] |= (1 << num);
                    subs[i / 3][j / 3] |= (1 << num);
                } else {
                    miss.add(i * 9 + j);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), miss, rows, cols, subs, 0);
        for (int i = 0; i < miss.size(); i++) {
            int r = miss.get(i) / 9;
            int c = miss.get(i) % 9;
            board[r][c] = (char) (res.get(0).get(i) + '0');
        }
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> tempList,
                           List<Integer> miss, int[] rows, int[] cols, int[][] subs, int index) {
        if (index == miss.size()) {
            res.add(new ArrayList<>(tempList));
            System.out.println(tempList);
            return;
        }
        int r = miss.get(index) / 9;
        int c = miss.get(index) % 9;
        int used = rows[r] | cols[c] | subs[r / 3][c / 3];

        for (int candidate = 1; candidate <= 9; candidate++) {
            int test = 1 << candidate;
            if ((used & test) > 0) {
                continue;
            }
            rows[r] |= test;
            cols[c] |= test;
            subs[r / 3][c / 3] |= test;
            tempList.add(candidate);
            backtrack(res, tempList, miss, rows, cols, subs, index + 1);
            tempList.remove(tempList.size() - 1);
            rows[r] -= test;
            cols[c] -= test;
            subs[r / 3][c / 3] -= test;
        }
    }
}
