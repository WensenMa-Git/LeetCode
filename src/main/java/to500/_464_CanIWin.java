package to500;

import java.util.Arrays;
import java.util.HashMap;


public class _464_CanIWin {


    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        char[] remain = new char[maxChoosableInteger + 1];
        Arrays.fill(remain, '1');
        return canWin(remain, new HashMap<>(), desiredTotal);
    }

    private boolean canWin(char[] remain, HashMap<String, Boolean> map, int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        String status = new String(remain);
        if (map.containsKey(status)) {
            return map.get(status);
        }
        boolean res = false;

        for (int i = 1; i < remain.length; i++) {
            if (remain[i] == '0') {
                continue;
            }
            remain[i] = '0';
            if (!canWin(remain, map, desiredTotal - i)) {
                res = true;
            }
            remain[i] = '1';
            if (res) {
                break;
            }
        }
        map.put(status, res);
        return res;
    }
}
