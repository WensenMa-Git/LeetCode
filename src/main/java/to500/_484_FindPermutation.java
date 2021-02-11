package to500;


public class _484_FindPermutation {


    public int[] findPermutation(String s) {
        int len = s.length();
        int[] res = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            res[i] = i + 1;
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'D') {
                int start = i;
                while (i < len && s.charAt(i) == 'D') {
                    i++;
                }
                reverse(res, start, i);
            }
        }
        return res;
    }

    public void reverse(int[] array, int left, int right) {
        while (left < right) {
            int t = array[left];
            array[left] = array[right];
            array[right] = t;
            left++;
            right--;
        }
    }
}
