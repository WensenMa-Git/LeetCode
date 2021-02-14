package leetcode.to500;


public class _488_ZumaGame {

    final int MAX_COUNT = 6;

    public int findMinStep(String board, String hand) {
        int[] count = new int[26];
        for (int i = 0; i < hand.length(); i++) {
            count[hand.charAt(i) - 'A']++;
        }
        int res = helper(board + "#", count);
        return res == MAX_COUNT ? -1 : res;
    }

    private int helper(String s, int[] count) {
        s = remove(s);
        if (s.equals("#")) {
            return 0;
        }
        int res = MAX_COUNT;
        for (int j = 0, i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) {
                continue;
            }
            int need = 3 - (i - j);
            if (count[s.charAt(j) - 'A'] >= need) {
                count[s.charAt(j) - 'A'] -= need;
                res = Math.min(res, need + helper(s.substring(0, j) + s.substring(i), count));
                count[s.charAt(j) - 'A'] += need;
            }
            j = i;
        }
        return res;
    }

    private String remove(String board) {
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(j) == board.charAt(i)) {
                continue;
            }
            if (j - i >= 3) {
                return remove(board.substring(0, i) + board.substring(j));
            } else {
                i = j;
            }
        }
        return board;
    }

}
