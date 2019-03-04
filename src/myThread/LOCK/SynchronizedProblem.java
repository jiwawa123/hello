package myThread.LOCK;/*
    user ji
    data 2019/3/3
    time 5:58 PM
*/

public class SynchronizedProblem {
    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                System.out.println("t1");
                SynchronizedProblem.run();
            }
        }.start();
        Thread.sleep(20);
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("t2");
                SynchronizedProblem.run();
            }
        };
        t2.start();
        Thread.sleep(20);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
    }

    private synchronized static void run() {
        System.out.println(Thread.currentThread().getName());
        while (true) {

        }

    }
}
