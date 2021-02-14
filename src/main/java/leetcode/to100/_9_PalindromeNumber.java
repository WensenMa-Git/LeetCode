package leetcode.to100;

/**
 * https://leetcode.com/problems/palindrome-number/
 * Subject: Math
 * #Easy
 */
public class _9_PalindromeNumber {

    //Preferred solution.
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false;
        int palind = x;
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return palind == rev;
    }

    //Provide a second solution.
    public boolean isPalindrome2(int x) {
        if(x < 0) return false;
        int div = 1;
        while(x / div > 9){
            div *= 10;
        }
        while(x > 0){
            int left = x / div;
            int right = x % 10;
            x = (x % div) / 10;
            div /= 100;
            if(left != right) return false;
        }
        return true;
    }
}
