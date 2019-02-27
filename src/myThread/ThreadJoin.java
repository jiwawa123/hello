package myThread;/*
    user ji
    data 2019/2/27
    time 7:08 PM
*/

public class ThreadJoin {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        },"t0");
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        },"t1");
        t.start();
        t1.start();
        try {
            t.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
