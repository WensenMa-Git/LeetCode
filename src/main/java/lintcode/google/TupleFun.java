package lintcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TupleFun {

    static class Tuple {
        public String description;
        public int start;
        public int end;
    }

    public void tupleFunction (List<Tuple> tupleList) {
        Map<Integer, List<Tuple>> map = new HashMap<>();
        for (Tuple tuple : tupleList) {
            insert(tuple, map);
        }

//        for (Map.Entry<Integer, List<Tuple>> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + entry.getValue());
//        }
    }

    private void insert(Tuple tuple, Map<Integer, List<Tuple>> map) {
        for (int i = 0; i <= map.size(); i++) {
            if (i == map.size()) {
                List<Tuple> newList = new ArrayList<>();
                newList.add(tuple);
                map.put(i, newList);
                return;
            } else {
                List<Tuple> cur = map.get(i);
                if (insert(tuple, cur)) {
                    break;
                }
            }
        }
    }

    private boolean insert(Tuple tuple, List<Tuple> tupleList) {
        int left = 0, right = tupleList.size() - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (tupleList.get(middle).start >= tuple.end) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (right == -1 || tupleList.get(right).end <= tuple.start) {
            tupleList.add(right + 1, tuple);
            return true;
        } else {
            return false;
        }
    }

}
