package to100;

/**
 * https://leetcode.com/problems/word-search/
 */
public class _79_WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int start) {
        if (start >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] == word.charAt(start++)) {
            char c = board[i][j];
            board[i][j] = '#';
            boolean res = exist(board, i + 1, j, word, start) ||
                    exist(board, i - 1, j, word, start) ||
                    exist(board, i, j + 1, word, start) ||
                    exist(board, i, j - 1, word, start);
            board[i][j] = c;
            return res;
        }
        return false;
    }

    //Provide a second solution (Preferred)
    public boolean exist2(char[][] board, String word) {
        char[] wordLetters = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, wordLetters, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean search(char[][]board, char[] wordLetters, int i, int j, int index) {
        if (i < 0 || i >= board.length || j >= board[0].length || j < 0 || board[i][j] != wordLetters[index])               {
            return false;
        }
        if (index == wordLetters.length - 1) {
            return true;
        }
        char letter = board[i][j];
        board[i][j] = '.';
        if (search(board, wordLetters, i + 1, j, index + 1)
                || search(board, wordLetters, i - 1, j, index + 1)
                || search(board, wordLetters, i, j + 1, index + 1)
                || search(board, wordLetters, i, j - 1, index + 1)) {
            return true;
        }
        board[i][j] = letter;
        return false;
    }
}