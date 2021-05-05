package leetcode.to500;

/**
 * https://leetcode.com/problems/sentence-screen-fitting/
 * Subject: Array, String
 * #Medium #Google
 */
public class _418_SentenceScreenFitting {

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0;
        int len = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start / len;
    }

    //Provide a second solution. (Preferred)
    public int wordsTyping2(String[] sentence, int rows, int cols) {

        int row=rows;
        int col=cols;
        int index=0;
        int ans=0;

        while (row>0) {
            String word= sentence[index];

            if (word.length() <=col) {
                col=col-word.length();
                index++;
                if (col>0){
                    col=col-1;
                }
            }
            else {
                col=cols;
                row--;
            }

            if (index==sentence.length) {
                ans++;
                index=0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] s = new String[]{
                "a", "bcd", "e"
        };
        wordsTyping(s, 3, 6);
    }
}
