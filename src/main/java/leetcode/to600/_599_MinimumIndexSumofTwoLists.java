package leetcode.to600;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class _599_MinimumIndexSumofTwoLists {


    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= min) {
                if (i + j < min) {
                    res.clear();
                    min = i + j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
