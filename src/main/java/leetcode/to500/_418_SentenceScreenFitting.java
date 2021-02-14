package leetcode.to500;


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

    public static void main(String[] args) {
        String[] s = new String[]{
                "a", "bcd", "e"
        };
        wordsTyping(s, 3, 6);
    }
}
