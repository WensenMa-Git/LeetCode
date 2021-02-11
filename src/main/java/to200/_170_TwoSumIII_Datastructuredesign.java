package to200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class _170_TwoSumIII_Datastructuredesign {


    private HashMap<Integer, Integer> map;
    private List<Integer> list;


    // 构造函数，leetcode中是TwoSum
    public _170_TwoSumIII_Datastructuredesign() {
        map = new HashMap<>();
    }

    // time : O(n)

    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }


    //构造函数，leetcode中是TwoSum, map 在上一个解法中有

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = value - i;
            if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) {
                return true;
            }
        }
        return false;
    }

    public void TwoSum() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void add2(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
            list.add(number);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    // time : O(n)
    public boolean find2(int value) {
        for (Integer num1 : list) {
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}