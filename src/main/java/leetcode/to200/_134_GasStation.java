package leetcode.to200;

/**
 * https://leetcode.com/problems/gas-station/
 * Subject: Array
 * #Medium
 */
public class _134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (sum < 0) {
                sum = (gas[i] - cost[i]);
                start = i;
            } else {
                sum += (gas[i] - cost[i]);
            }
        }
        return total < 0 ? -1 : start;
    }

    //Provide a second solution (Preferred)
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int loss = 0;
        int surplus = 0; //盈余
        int res = 0;
        for(int i = 0; i < gas.length; i++){
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                loss += surplus;
                surplus = 0;
                res = i + 1;
            }
        }
        loss += surplus;
        return loss < 0 ? -1 : res;
    }
}
