package leetcode.to100;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * Subject: Array
 * #Medium
 */
public class _73_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    //Provide a second solution (Preferred)
    public void setZeroes2(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;
        for(int r = 0; r < m; r++){
            if(matrix[r][0] == 0) col0 = 0;
            for(int c = 1; c < n; c++){
                if(matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for(int r = m - 1; r >= 0; r--){
            for(int c = 1; c < n; c++){
                if(matrix[r][0] == 0 || matrix[0][c] == 0){
                    matrix[r][c] = 0;
                }
            }
            if(col0 == 0) matrix[r][0] = 0;
        }
    }
}
