package supplement.thread.rw;

public class ZTest {

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        StringBuffer sb = new StringBuffer();
        Thread r_thread = new Thread(new Reader(readWriteLock, sb));
        Thread w_thread = new Thread(new Writer(readWriteLock, sb));

        r_thread.start();
        w_thread.start();
        try {
            r_thread.join();
            w_thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
