package to400;


public class _374_GuessNumberHigherorLower {

    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (guess((mid)) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (guess(start) == 0) return start;
        return end;
    }


    // 防止编译器报错函数
    public int guess(int num) {
        return 0;
    }
}
