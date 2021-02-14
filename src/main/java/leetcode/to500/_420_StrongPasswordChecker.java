package leetcode.to500;


public class _420_StrongPasswordChecker {

    public static int strongPasswordChecker(String s) {
        int res = 0;
        int lower = 1, upper = 1, digit = 1;
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); ) {
            if (Character.isLowerCase(s.charAt(i))) lower = 0;
            if (Character.isUpperCase(s.charAt(i))) upper = 0;
            if (Character.isDigit(s.charAt(i))) digit = 0;

            int j = i;
            while (i < s.length() && s.charAt(i) == s.charAt(j)) {
                i++;
            }
            arr[j] = i - j;
        }

        int miss = (lower + upper + digit);

        if (arr.length < 6) {
            int diff = 6 - s.length();
            res += diff + Math.max(0, miss - diff);
        } else {
            int over = Math.max(s.length() - 20, 0);
            res += over;
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && over > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) {
                        continue;
                    }
                    arr[i] -= Math.min(over, k);
                    over -= k;
                }
            }

            int replacement = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 3 && over > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= over;
                    over -= need;
                }

                if (arr[i] >= 3) replacement += arr[i] / 3;
            }

            res += Math.max(miss, replacement);
        }

        return res;
    }

    public static void main(String[] args) {
        strongPasswordChecker("xxxxxxxxxxxxxxxxxxxxx3yT");
    }
}
