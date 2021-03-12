package leetcode.to300;

import java.util.HashSet;
import java.util.Set;


public class _202_HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int squareSum, remain;
        while (set.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }

    //Provide a second solution (Preferred)
    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(n!=1){
            int sum = 0;
            while(n>0){
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if(set.contains(sum)){
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
        return true;
    }

    //Provide a third solution.
    public boolean isHappy3(int n) {

        while(n != 1 && n != 7) {
            if(n < 10)
                return false;
            int sum = 0;
            while(n != 0) {
                sum += (n%10) * (n%10);
                n = n/10;
            }
            n = sum;
        }
        return true;
    }

}
