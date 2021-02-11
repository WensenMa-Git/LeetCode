package to600;


public class _517_SuperWashingMachines {


    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int machine : machines) {
            total += machine;
        }
        if (total % machines.length != 0) {
            return -1;
        }
        int avg = total / machines.length;
        int res = 0;
        int count = 0;
        for (int load : machines) {
            count += load - avg;
            res = Math.max(res, Math.max(Math.abs(count), load - avg));
        }
        return res;
    }
}
