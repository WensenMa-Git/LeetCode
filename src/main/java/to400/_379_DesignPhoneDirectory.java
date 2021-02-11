package to400;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class _379_DesignPhoneDirectory {


    HashSet<Integer> used = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    int maxNumbers;

    public _379_DesignPhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
    }

    public int get() {
        Integer res = queue.poll();
        if (res == null) {
            return -1;
        }
        used.add(res);
        return res;
    }

    public boolean check(int number) {
        if (number >= maxNumbers || number < 0) {
            return false;
        }
        return !used.contains(number);
    }

    public void release(int number) {
        if (used.remove(number)) {
            queue.offer(number);
        }
    }
}
