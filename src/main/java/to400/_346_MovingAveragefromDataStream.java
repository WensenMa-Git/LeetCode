package to400;

import java.util.LinkedList;
import java.util.Queue;


public class _346_MovingAveragefromDataStream {


    private final Queue<Integer> queue;
    private final int size;
    private double sum = 0;

    public _346_MovingAveragefromDataStream(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.remove();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }
}
