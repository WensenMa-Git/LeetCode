package leetcode.toLast;

/**
 * https://leetcode.com/problems/rle-iterator/
 * Subject: Array
 * #Medium #Google
 */
public class _900_RLEIterator {

    int index;
    int[] A;
    public _900_RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }

    public int next(int n) {
        if (index >= A.length) {
            return -1;
        }

        if (n <= A[index]) {
            A[index] -= n;
            return A[index + 1];
        } else {
            index += 2;
            return next(n - A[index - 2]);
        }
    }
}
