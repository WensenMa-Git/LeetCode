package leetcode.to100;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * Subject: Array
 * #Medium
 */
public class _59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = num++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;

            for (int i = colEnd; i >= colBegin; i--) {
                matrix[rowEnd][i] = num++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin] = num++;
            }
            colBegin++;
        }
        return matrix;
    }

    //Provide a second solution (Preferred)
    public int[][] generateMatrix2(int n) {
        if(n <= 0) return null;
        int[][] res = new int[n][n];
        int rows = n, columns = n;
        int r = 0, c = -1;

        int count = 1;
        while(true) {
            for(int i = 0; i < columns; i++) {
                res[r][++c] = count++;
            }
            if(--rows == 0) {
                break;
            }
            for(int i = 0; i < rows; i++) {
                res[++r][c] = count++;
            }
            if(--columns == 0) {
                break;
            }
            for(int i = 0; i < columns; i++) {
                res[r][--c] = count++;
            }
            if(--rows == 0) {
                break;
            }
            for(int i = 0; i < rows; i++) {
                res[--r][c] = count++;
            }
            if(--columns == 0) {
                break;
            }
        }
        return res;
    }

}
