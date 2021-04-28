package leetcode.to300;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 * Subject: Array
 * #Medium
 */
public class _299_BullsandCows {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (count[secret.charAt(i) - '0']++ < 0) cows++;
                if (count[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    //Provide a second solution. (Preferred)
    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int maxCows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                maxCows++;
                count[secret.charAt(i) - '0']++;
                count[guess.charAt(i) - '0']--;
            }
        }
        int leftCows = 0;
        for (int c : count) {
            if (c > 0) {
                leftCows += c;
            }
        }
        return bulls + "A" + (maxCows - leftCows) + "B";
    }
}
