package leetcode.to100;

import java.util.ArrayList;
import java.util.List;


public class _54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }

    //Provide a second solution (Preferred)
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return list;
        int n = matrix[0].length;
        int r = 0;
        int c = -1;
        while (true) {
            for (int i = 0; i < n; i++) {
                list.add(matrix[r][++c]);
            }
            if (--m == 0) break;
            for (int i = 0; i < m; i++) {
                list.add(matrix[++r][c]);
            }
            if (--n == 0) break;
            for (int i = 0; i < n; i++) {
                list.add(matrix[r][--c]);
            }
            if (--m == 0) break;
            for (int i = 0; i < m; i++) {
                list.add(matrix[--r][c]);
            }
            if (--n == 0) break;
        }
        return list;
    }
}