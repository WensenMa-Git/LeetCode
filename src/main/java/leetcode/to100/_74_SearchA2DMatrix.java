package leetcode.to100;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * Subject: Binary Search
 * #Medium
 */
public class _74_SearchA2DMatrix {

    //Preferred Solution.
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int begin = 0, end = row * col - 1;
        while (begin <= end) {
            int mid = (end - begin) / 2 + begin;
            int value = matrix[mid / col][mid % col];
            if (value == target) {
                return true;
            } else if (value < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    //Provide a second solution.
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
