package to400;


public class _348_DesignTicTacToe {


    private final int[] rows;
    private final int[] cols;
    private final int size;
    private int diagonal;
    private int antiDiagonal;

    public _348_DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.size = n;
    }

    //time : O(1)
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }
        if (col == (cols.length - row - 1)) {
            antiDiagonal += toAdd;
        }
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size
                || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }
}
