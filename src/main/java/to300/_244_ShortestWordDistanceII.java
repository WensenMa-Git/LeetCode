package to300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class _244_ShortestWordDistanceII {


    //_244_ShortestWordDistanceII 这个题在leetcode中构造函数是 WordDistance

    private final HashMap<String, List<Integer>> map;


    public _244_ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    //time : O(n * m)
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (Integer num1 : l1) {
            for (Integer num2 : l2) {
                res = Math.min(res, Math.abs(num1 - num2));
            }
        }
        return res;
    }

    //time : O(n + m)
    public int shortest2(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

}
