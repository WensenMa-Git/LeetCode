package leetcode.to100;

/**
 * https://leetcode.com/problems/rotate-image/
 * Subject: Array
 * #Medium
 */
public class _48_RotateImage {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    //Provide a second solution (Preferred)
    public void rotate2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int up = 0, down = m - 1; up < down; up++, down--) {
            for (int c = 0; c < n; c++) {
                int temp = matrix[up][c];
                matrix[up][c] = matrix[down][c];
                matrix[down][c] = temp;
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < r; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

}
