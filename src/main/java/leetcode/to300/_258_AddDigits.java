package leetcode.to300;


public class _258_AddDigits {

    public static int addDigits1(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum >= 10) {
            return addDigits1(sum);
        } else {
            return sum;
        }
    }

    public static int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
