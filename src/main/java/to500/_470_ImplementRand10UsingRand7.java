package to500;


public class _470_ImplementRand10UsingRand7 {


    public int rand10() {
        int res = 40;
        while (res >= 40) {
            res = 7 * (rand7() - 1) + rand7() - 1;
        }
        return res % 10 + 1;
    }

    private int rand7() {
        return 0;
    }
}
