package to400;

import java.util.LinkedList;
import java.util.Queue;


public class _362_DesignHitCounter {


    Queue<Integer> queue;
    private int[] times;
    private int[] hits;


    public _362_DesignHitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }

    public void DesignHitCounter2() {
        times = new int[300];
        hits = new int[300];
    }


    public void hit2(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }


    public int getHits2(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
    }
}
