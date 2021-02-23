package leetcode.to100;

/**
 * https://leetcode.com/problems/add-binary/
 * Subject: String
 * #Easy
 */
public class _67_AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0;
        while (i >= 0 || j >= 0) {
            int sum = remainder;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            remainder = sum / 2;
        }
        if (remainder != 0) {
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }

    //Provide a second solution (Preferred).
    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        while (indexA >= 0 || indexB >=0 || carry > 0) {
            int bitA = 0;
            if (indexA >= 0) {
                bitA = a.charAt(indexA--) - '0';
            }
            int bitB = 0;
            if (indexB >= 0) {
                bitB = b.charAt(indexB--) - '0';
            }
            int sum = bitA + bitB + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}
