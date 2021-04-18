package leetcode.to300;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-iterator/
 * Subject: Array
 * #Medium
 */
public class _281_ZigzagIterator {

    LinkedList<Iterator> list;
    private Iterator<Integer> i, j, temp;

    public _281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            temp = j;
            j = i;
            i = temp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }

    public void ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if (!v1.isEmpty()) list.add(v1.iterator());
        if (!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next2() {
        Iterator poll = list.remove();
        int result = (Integer) poll.next();
        if (poll.hasNext()) {
            list.add(poll);
        }
        return result;
    }

    public boolean hasNext2() {
        return !list.isEmpty();
    }

    //Provide a second solution. (Preferred).
    class ZigzagIterator {

        private int index1 = 0;
        private int index2 = 0;
        private List<Integer> v1;
        private List<Integer> v2;
        private boolean flag = false;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public int next() {
            flag = !flag;
            if (flag) {
                if (index1 < v1.size()) {
                    return v1.get(index1++);
                } else {
                    return v2.get(index2++);
                }
            } else {
                if (index2 < v2.size()) {
                    return v2.get(index2++);
                } else {
                    return v1.get(index1++);
                }
            }
        }

        public boolean hasNext() {
            return index1 != v1.size() || index2 != v2.size();
        }
    }
}
