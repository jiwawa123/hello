package myThread;/*
    user ji
    data 2019/3/1
    time 2:54 PM
*/

public class SynchronizedTest {
    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (LOCK) {
                try {
                    Thread.sleep(1_1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}
