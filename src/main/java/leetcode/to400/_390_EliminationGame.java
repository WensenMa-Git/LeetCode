package leetcode.to400;


public class _390_EliminationGame {

    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int res = 1; // head
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                res = res + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return res;
    }
}
