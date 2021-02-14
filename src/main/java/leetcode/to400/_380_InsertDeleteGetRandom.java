package leetcode.to400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class _380_InsertDeleteGetRandom {


    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rmd;

    public _380_InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rmd = new Random();
    }


    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }


    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        return true;
    }


    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}
