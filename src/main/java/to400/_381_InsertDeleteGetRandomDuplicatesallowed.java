package to400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


public class _381_InsertDeleteGetRandomDuplicatesallowed {


    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> list;
    Random rmd;

    public _381_InsertDeleteGetRandomDuplicatesallowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rmd = new Random();
    }


    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }


    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.get(lastVal).remove(list.size());
            map.get(lastVal).add(index);
        }
        return true;
    }


    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}
