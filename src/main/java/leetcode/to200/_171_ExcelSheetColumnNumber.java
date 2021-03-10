package leetcode.to200;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * Subject: Math
 * #Easy
 */
public class _171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
