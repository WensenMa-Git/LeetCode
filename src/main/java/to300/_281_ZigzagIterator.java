package to300;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


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
}
