package to100;


public class _70_ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public int climbStairs2(int n) {
        if (n <= 1) return 1;
        int oneStep = 1, twoStep = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = res;
        }
        return res;
    }

    //Provide a third solution (Preferred)
    public int climbStairs3(int n) {
        int f0 = 1;
        int f1 = 1;
        for(int i = 2; i <= n; i++){
            int temp = f0 + f1;
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }
}
