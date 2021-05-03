package supplement.thread.rw2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Writer implements Runnable{

    private ReentrantReadWriteLock lock;

    public Writer(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    public void write(){}

    @Override
    public void run() {
        lock.writeLock().lock();

        try {
            write();
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName()
                    + "  Time Taken " + (duration / 1000) + " seconds.");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
