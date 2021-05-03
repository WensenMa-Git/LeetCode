package supplement.thread.rw2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Reader implements Runnable{

    private ReentrantReadWriteLock lock;

    public Reader(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    public void read() {}

    @Override
    public void run() {
        if(lock.isWriteLocked()) {
            System.out.println("Write Lock Present.");
        }
        lock.readLock().lock();

        try {
            read();
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName()
                    + "  Time Taken " + (duration / 1000) + " seconds.");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}
