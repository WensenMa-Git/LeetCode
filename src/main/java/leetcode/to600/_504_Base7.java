package leetcode.to600;


public class _504_Base7 {


    public String convertToBase7(int num) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        boolean negative = false;

        if (num < 0) {
            negative = true;
        }
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }
        if (negative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public String convertToBase72(int num) {
        if (num < 0) {
            return "-" + convertToBase72(-num);
        }
        if (num < 7) {
            return num + "";
        }
        return convertToBase72(num / 7) + num % 7;
    }
}
