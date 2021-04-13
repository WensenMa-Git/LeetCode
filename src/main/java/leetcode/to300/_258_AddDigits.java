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

    //Provide a third solution. (Preferred)
    public int addDigits3(int num) {
        if (num < 10) return num;
        int result = 0;
        while(num >= 10){
            result = 0;
            while(num > 0){
                result += num % 10;
                num = num / 10;
            }
            num = result;
        }
        return result;
    }

    //Provide a fourth solution. (Preferred)
    public int addDigits(int num) {
        int temp = 0;
        while (num >= 10) {
            temp = num;
            num = 0;
            while(temp > 0) {
                num += temp % 10;
                temp /= 10;
            }
        }
        return num;
    }
}
