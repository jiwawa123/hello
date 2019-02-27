package myThread;/*
    user ji
    data 2019/2/27
    time 6:40 PM
*/

public class DaemonThread {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(3_100);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.setDaemon(true);
            t1.start();
            try {
                Thread.sleep(1_100);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(2_100);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
