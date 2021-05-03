package supplement.thread.rw;

public class Reader implements Runnable{

    private ReadWriteLock readWriteLock;

    public Reader(ReadWriteLock readWriteLock, StringBuffer sb) {
        this.readWriteLock = readWriteLock;
    }

    public void read(){}

    @Override
    public void run() {
        try {
            readWriteLock.lockRead();
            read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.unlockRead();
        }
    }
}
