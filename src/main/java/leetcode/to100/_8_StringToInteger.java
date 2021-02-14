package leetcode.to100;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * Subject: String
 * #Medium
 */
public class _8_StringToInteger {

    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }

    //Provide a second solution (Preferred)
    public int myAtoi2(String str) {
        char[] sChars = str.trim().toCharArray();
        if(sChars.length == 0) return 0;
        int index = 0;
        int sign = 1;
        if(sChars[index] == '+'){
            index++;
        }else if(sChars[index] == '-'){
            index++;
            sign = -1;
        }

        int num = 0;
        while(index < sChars.length){
            if(sChars[index] < '0' || sChars[index] > '9') break;
            int digit = sChars[index] - '0';
            if(num > 214748364 || (num == 214748364 && digit >= 8)){
                if(sign == 1) return 2147483647;
                return -2147483648;
            }
            num = num * 10 + digit;
            index++;
        }
        return num * sign;
    }
}
