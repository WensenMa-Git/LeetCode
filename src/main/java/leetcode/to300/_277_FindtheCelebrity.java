package leetcode.to300;

/**
 * https://leetcode.com/problems/find-the-celebrity/
 * Subject: Array
 * #Medium
 */
public class _277_FindtheCelebrity {

    public int findCelebrity(int n) {
        if (n < 2) return -1;
        int possible = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possible, i)) {
                possible = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (possible != i && ((knows(possible, i) || !knows(i, possible)))) {
                return -1;
            }
        }
        return possible;
    }

    public boolean knows(int a, int b) {
        return true;
    }

    private int numberOfPeople;

    //Provide a second solution. (Preferred)
    public int findCelebrity2(int n) {
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }

    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue; // Don't ask if they know themselves.
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }

    //Provide a third solution. (Brute force)
    public int findCelebrity3(int n) {
        numberOfPeople = n;
        for (int i = 0; i < n; i++) {
            if (isCelebrity(i)) {
                return i;
            }
        }
        return -1;
    }
}
