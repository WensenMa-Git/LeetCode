package leetcode.to100;

/**
 * https://leetcode.com/problems/count-and-say/
 * Subject: Two Pointer
 * #Medium
 */
public class _38_CountandSay {

    public String countAndSay(int n) {
        int i = 1;
        String res = "1";
        while (i < n) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            for (int j = 0; j <= res.length(); j++) {
                if (j != res.length() && res.charAt(j) == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    if (j != res.length()) {
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }
            res = sb.toString();
            i++;
        }
        return res;
    }

    //Provide a second solution (Preferred)
    public String countAndSay2(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = compress(s);
        }
        return s;
    }

    private String compress(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int L = 0, R = 1; R <= arr.length; R++){
            if(R == arr.length || arr[R] != arr[L]){
                sb.append(R - L);
                sb.append(arr[L]);
                L = R;
            }
        }
        return sb.toString();
    }
}
