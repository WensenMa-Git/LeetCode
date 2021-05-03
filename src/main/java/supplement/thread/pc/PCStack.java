package supplement.thread.pc;

import java.util.*;

/**
 * http://tutorials.jenkov.com/java-concurrency/read-write-locks.html
 * https://www.tutorialspoint.com/java_concurrency/concurrency_readwritelock.htm
 */

//One Producer and one consumer
public class PCStack {

    private Queue<Integer> list = new LinkedList<>();

    synchronized public void push(Integer value) {
        try {
            if (list.size() >= 10) {
                this.wait();
            }
            this.list.add(value);
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public int pop() {
        try {
            if (list.size() == 0) {
                this.wait();
            }
            int res = list.poll();

            this.notify();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        PCStack pcStack = new PCStack();

        Thread p_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    pcStack.push(1);
                }
            }
        });

        Thread c_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    int res = pcStack.pop();
                }
            }
        });

        c_thread.start();
        p_thread.start();
    }

}
