package to500;

import java.util.HashMap;
import java.util.LinkedHashSet;


public class _460_LFUCache {


    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> list;
    int capacity;
    int min;

    public _460_LFUCache(int capacity) {
        this.capacity = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        list = new HashMap<>();
        list.put(1, new LinkedHashSet<>());
        min = -1;
    }

    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        list.get(count).remove(key);
        if (count == min && list.get(count).size() == 0) {
            min++;
        }
        if (!list.containsKey(count + 1)) {
            list.put(count + 1, new LinkedHashSet<>());
        }
        list.get(count + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= capacity) {
            int evit = list.get(min).iterator().next();
            list.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        list.get(1).add(key);
    }
}
