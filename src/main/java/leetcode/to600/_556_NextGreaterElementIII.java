package leetcode.to600;


public class _556_NextGreaterElementIII {


    public int nextGreaterElement(int n) {
        char[] res = ("" + n).toCharArray();
        int i = res.length - 2;
        while (i >= 0 && res[i + 1] <= res[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = res.length - 1;
        while (j >= 0 && res[j] <= res[i]) {
            j--;
        }
        swap(res, i, j);
        reverse(res, i + 1);
        long val = Long.parseLong(new String(res));
        return val <= Integer.MAX_VALUE ? (int) val : -1;
    }

    private void reverse(char[] chars, int start) {
        int i = start, j = chars.length - 1;
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
