package to500;


public class _476_NumberComplement {


    public int findComplement(int num) {
        int sum = 0;
        while (sum < num) {
            sum = (sum << 1) | 1;
        }
        return sum - num;
    }
}
