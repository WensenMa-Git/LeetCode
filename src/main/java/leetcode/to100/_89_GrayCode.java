package leetcode.to100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 * Subject: 找规律
 * #Medium
 */
public class _89_GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }

    /*
    The key is to find the pattern.
    n=0: 0
    n=1: 0, 1
    n=2: 0, 1, 11, 10
    n=3: 0, 1, 11, 10, 110, 111, 101, 100
    .....
    */
    //Provide a second solution.
    public List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList();
        result.add(0);
        for (int i = 1; i <= n; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) | (1 << (i - 1)));
            }
        }
        return result;
    }
}
