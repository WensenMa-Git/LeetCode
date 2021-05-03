package supplement.thread.rw;

public class Writer implements Runnable{

    private ReadWriteLock readWriteLock;

    public Writer(ReadWriteLock readWriteLock, StringBuffer sb) {
        this.readWriteLock = readWriteLock;
    }

    public void write(){}

    @Override
    public void run() {

        try {
            readWriteLock.lockWrite();
            write();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                readWriteLock.unlockWrite();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
