package leetcode.to200;


public class _168_ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) ('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    //Provide a second solution (Preferred).
    public String convertToTitle2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) ((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
